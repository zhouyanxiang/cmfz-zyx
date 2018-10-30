package com.baizhi.test;

import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by admin on 2018/10/28.
 */
public class TestPoi extends TestObject {

    @Autowired
    UserService userService;

    @Test
    public void testExcel() throws IOException {
        //测试poi导出excel表格
        /*创建excel文件*/
        HSSFWorkbook workbook = new HSSFWorkbook();
        /*创建工作表*/
        HSSFSheet sheet = workbook.createSheet("User");
        /*创建行 参数是行下标*/
        HSSFRow row = sheet.createRow(0);
        /*创建单元格,参数是单元格下标*/
        HSSFCell cell = row.createCell(0);
        /*填充单元格*/
        cell.setCellValue("第一次尝试导出单元格");
        /*将单元格从内存写出到磁盘*/
        workbook.write(new FileOutputStream(new File("E://项目导出/user.xls")));


    }

    public void ExportAll(HttpServletResponse response){

        userService.exportAll(response);
        System.out.println();
    }
}
