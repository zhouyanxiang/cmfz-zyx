package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by admin on 2018/10/25.
 */

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @RequestMapping("/addChapter")
    @ResponseBody
    public boolean addChapter(Chapter chapter, int pid, MultipartFile music, HttpServletRequest request) throws IOException {

        /**
         * 存放位置
         * 上传
         * 别名
         */
        boolean data = false;
        if (pid != 0) {
            long size = music.getSize();
            double size1 = size / 1024;
            chapter.setSize(size1);

            String path = request.getSession().getServletContext().getRealPath("/");
            File file = new File(path + "/music");
            if (!file.exists()) {
                file.mkdir();
            }

            //   1.jpg
            String originalFilename = music.getOriginalFilename();
            String s = UUID.randomUUID().toString();
            String extension = FilenameUtils.getExtension(originalFilename);
            String newName = s + "." + extension;

            chapter.setUrl(newName);

            try {
                music.transferTo(new File(file, newName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            File source = new File(path + "/music/" + newName);
            Encoder encoder = new Encoder();
            try {
                MultimediaInfo m = encoder.getInfo(source);
                long ls = m.getDuration();
                long second = ls / 1000;
                chapter.setDuration(second);

                System.out.println("此视频时长为:" + second + "秒！");
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println(chapter + "________" + music + "____music");


            chapterService.addChapter(chapter);

            data = true;
            return data;
        }


        return data;

    }


    @RequestMapping("/down")
    @ResponseBody
    public void down(String title, String url, HttpServletRequest request, HttpServletResponse response) {

        /*下载
        * 找到这个文件
        * 响应文件数据
        * */

        System.out.println("title+++"+title+",url++++"+url);
        String realPath = request.getSession().getServletContext().getRealPath("/music");
        String filePath = realPath + "/" + url;
        File audioFile = new File(filePath);

        String extension = FilenameUtils.getExtension(url);
        String newName = title + "." + extension;
        System.out.println("newName+++++++"+newName);

        try {
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(newName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setContentType("audio/mpeg");
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(audioFile));
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
