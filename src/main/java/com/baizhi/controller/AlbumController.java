package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/10/25.
 */

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping("/queryAllAlbumAndChapter")
    @ResponseBody
    public List<Album> queryAllAlbumAndChapter() {
        List<Album> albumList = albumService.queryAllAlbumAndChapter();
        System.out.println("albumList+++++++"+albumList);
        return albumList;

    }


    @RequestMapping("/queryAlbumInformation")
    @ResponseBody
    public Map queryAlbumInformation(int id, HttpServletRequest request) {
        Map map = new HashMap();
        Album album = albumService.selectAlbumInformation(1);

        map.put("album", album);

        return map;

    }

    @RequestMapping("/addAlbum")
    @ResponseBody
    public boolean addAlbum(Album album, MultipartFile img, HttpServletRequest request) throws IOException {
        System.out.println("img+++" + img);
        boolean data = false;
        // 获取动态的上传地址
        if (!img.isEmpty()) {
            String realPath = request.getRealPath("/img");
            // 获取文件名字
            String originalFilename = img.getOriginalFilename();
            // 拼接获取到的文件名,形成一个新的文件名
            String fileName = new Date().getTime() + "_" + originalFilename;

            File file = new File(realPath + "/" + fileName);
            // 把上传上来的文件转换成file
            img.transferTo(file);
            System.out.println("filename*******" + fileName);

            album.setCoverImg(fileName);

            System.out.println("album****" + album);
            albumService.addAlbum(album);
            data = true;
            return data;
        }

        return data;


    }

}
