package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by admin on 2018/10/24.
 */

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    BannerService bannerService;

    @RequestMapping("/queryAllBanner")
    @ResponseBody
    public Map queryAllBanner(int page, int rows) {
        Map map = bannerService.queryAllBanner(page, rows);

        return map;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean delete(int id) {
        try {
            bannerService.deleteMany(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Banner banner) {
        try {
            bannerService.update(banner);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @RequestMapping("/add")
    @ResponseBody
    public boolean add(Banner banner, MultipartFile photo, HttpServletRequest request) throws IOException {

        System.out.println("banner****" + banner);
        System.out.println("photo+++"+photo);
        boolean data = false;
        // 获取动态的上传地址
       if(!photo.isEmpty()){
           String realPath = request.getRealPath("/img");
           // 获取文件名字
           String originalFilename = photo.getOriginalFilename();
           // 拼接获取到的文件名,形成一个新的文件名
           String fileName = new Date().getTime() + "_" + originalFilename;

           File file = new File(realPath + "/" + fileName);
           // 把上传上来的文件转换成file
           photo.transferTo(file);
           System.out.println("filename*******" + fileName);

           banner.setUrl(fileName);

           System.out.println("banner2****" + banner);
           bannerService.add(banner);
           boolean b = data = true;
           return b;
       }

        return data;

    }


}
