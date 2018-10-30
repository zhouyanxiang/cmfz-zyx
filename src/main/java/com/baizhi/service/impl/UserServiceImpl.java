package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by admin on 2018/10/28.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryAllUser() {
        List<User> users = userDao.selectAllUser();

        return users;
    }

    @Override
    public Map selectUserByTime() {

        int i = userDao.selectUserByTime(7);
        int i1 = userDao.selectUserByTime(14);
        int i2 = userDao.selectUserByTime(21);
        int[] all = {i, i1, i2};
        Map map = new HashMap();
        map.put("data", all);

        return map;
    }

    @Override
    public void add(User user) {
        userDao.insert(user);
    }

    //全部导出
    @Override
    public void exportAll(HttpServletResponse response) {
        List<User> userList = userDao.selectAllUser();
        List<String> titles = userDao.selectColumns();
        List<String> titleList = Arrays.asList("编号", "姓名", "密码","头像","法名", "性别", "省份", "城市", "签名", "电话", "加密", "状态", "注册日期");
        //创建Excel文件抽象对象
        Workbook workbook = new HSSFWorkbook();

        //设置日期格式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy/MM/dd");
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(format);

        //构建标题栏
        Sheet sheet = workbook.createSheet();
        Row row = sheet.createRow(0);
        for (int i = 0; i < titleList.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(titleList.get(i));
        }
        //构建数据行
        for (int i = 0; i < userList.size(); i++) {
            Row row1 = sheet.createRow(i + 1);
            Class<? extends User> aClass = userList.get(i).getClass();
            for (int j = 0; j < titles.size(); j++) {
                //用反射调用get方法
                String methodName = "get" + titles.get(j).substring(0, 1).toUpperCase() + titles.get(j).substring(1);
                try {
                    Object invoke = aClass.getDeclaredMethod(methodName, null).invoke(userList.get(i), null);
                    Cell cell = row1.createCell(j);
                    if (invoke instanceof Date) {
                        cell.setCellStyle(dateCellStyle);
                        cell.setCellValue((Date) invoke);
                        sheet.setColumnWidth(j, 22 * 256);
                    } else if (invoke instanceof Integer) {
                        cell.setCellValue((Integer) invoke);
                    } else if (invoke instanceof String) {
                        cell.setCellValue((String) invoke);
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


    }

    @Override
    public List<Map> selectAllUserDTO() {
        List<UserDTO> userDTOS = userDao.selectAllUserDTO();

        Map map = null;
        List<Map> mapList = new ArrayList<>();
        for (UserDTO userDTO : userDTOS) {
            map = new HashMap();
            map.put("name", userDTO.getProvince());
            map.put("value", userDTO.getCount());
            mapList.add(map);
        }
        return mapList;

    }
}
