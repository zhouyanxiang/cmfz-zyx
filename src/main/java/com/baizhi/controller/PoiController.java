package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.tomcat.util.net.openssl.OpenSSLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/10/28.
 */
@Controller
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    UserService userService;


    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) {

       userService.exportAll(response);

    }


    @RequestMapping("/importExcel")
    @ResponseBody
    public boolean importExcel(MultipartFile excel) {
        System.out.println("excel+++" + excel);
        boolean data = false;
        if (excel!=null) {
            Workbook workbook = null;
            try {
                InputStream inputStream = excel.getInputStream();
                workbook = new HSSFWorkbook(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Sheet sheet = workbook.getSheet("user");
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                double id = row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String pwd = row.getCell(2).getStringCellValue();
                String headPic = row.getCell(3).getStringCellValue();
                String DharmaName = row.getCell(4).getStringCellValue();
                String sex = row.getCell(5).getStringCellValue();
                String province = row.getCell(6).getStringCellValue();
                String city = row.getCell(7).getStringCellValue();
                String sign = row.getCell(8).getStringCellValue();
                String phoneNum = row.getCell(9).getStringCellValue();
                String salt = row.getCell(10).getStringCellValue();
                double status = row.getCell(11).getNumericCellValue();
                Date regDate = row.getCell(12).getDateCellValue();

                User user = new User();

                user.setId((new Double(id)).intValue());
                user.setName(name);
                user.setDharmaName(DharmaName);
                user.setSex(sex);
                user.setPassword(pwd);
                user.setProvince(province);
                user.setCity(city);
                user.setSign(sign);
                user.setPhoneNum(phoneNum);
                user.setStatus(new Double(status).intValue());
                user.setRegDate(regDate);
                user.setSalt(salt);
                user.setHeadPic(headPic);

                System.out.println(user);

                userService.add(user);

            }

            data = true;
            return data;

        }
        return data;

    }

    @RequestMapping("/customerExport")
    @ResponseBody
    public boolean customerExport(HttpServletResponse response, String titles, String fileds) {
        System.out.println("titles++"+titles+"----files++"+fileds);
        boolean data = false;
       if(!titles.isEmpty()&&!fileds.isEmpty()){
           List<User> users = userService.queryAllUser();
           String[] filedArray = fileds.split(",");
           String[] titleArray = titles.split(",");
           Workbook workbook = new HSSFWorkbook();

           CellStyle cellStyle1 = workbook.createCellStyle();
           //设置日期格式
           DataFormat dataFormat = workbook.createDataFormat();
           short format = dataFormat.getFormat("yyyy年mm月dd天");
           cellStyle1.setDataFormat(format);

           Sheet sheet = workbook.createSheet("user");
           Row row = sheet.createRow(0);
           for (int i = 0; i < titleArray.length; i++) {
               row.createCell(i).setCellValue(titleArray[i]);
           }

           for (int i = 0; i < users.size(); i++) {
               Row row1 = sheet.createRow(i + 1);
               Class<? extends User> aClass = users.get(i).getClass();
               for (int j = 0; j < filedArray.length; j++) {
                   //getId
                   String methodName = "get" + filedArray[j].substring(0, 1).toUpperCase() + filedArray[j].substring(1);
                   try {
                       Object invoke = aClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                       if (invoke instanceof Date) {
                           Cell cell = row1.createCell(j);
                           cell.setCellStyle(cellStyle1);
                           cell.setCellValue((Date) invoke);
                           sheet.setColumnWidth(j, 22 * 256);
                       } else if (invoke instanceof Integer) {
                           Cell cell = row1.createCell(j);
                           cell.setCellValue((Integer) invoke);
                       } else {
                           Cell cell = row1.createCell(j);
                           cell.setCellValue(String.valueOf(invoke));
                       }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }
           long time = new Date().getTime();
           String s = time + "文件.xls";
           try {
               response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(s, "utf-8"));
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
           response.setContentType("application/vnd.ms-excel");
           try {
               workbook.write(response.getOutputStream());
           } catch (IOException e) {
               e.printStackTrace();
           }
           data = true;
           return data;
       }

       return data;

    }

}
