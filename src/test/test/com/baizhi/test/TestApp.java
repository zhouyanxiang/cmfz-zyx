package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.dao.AlbumDao;
import com.baizhi.dao.BannerDao;
import com.baizhi.dao.MenuDao;
import com.baizhi.entity.*;
import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Created by admin on 2018/10/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfzApp.class)
public class TestApp {

    @Autowired
    AdminService service;
    @Autowired
    MenuDao dao;
    @Autowired
    BannerDao bannerDao;
    @Autowired
    AlbumDao albumDao;

    @Test
    public void login(){
        Admin admin = new Admin();
        admin.setName("张三仁波切");
        admin.setPassword("123456");
        Admin admin1 = service.login(admin);
        System.out.println(admin1);
    }

    @Test
   public void selectAllMenu(){
       List<Menu> list = dao.selectAll();

        for (Menu menu : list) {
            System.out.println(menu);
        }




   }

   @Test
   public void queryAllBanner(){

       List<Banner> bannerList = bannerDao.selectAll(1,5);

       System.out.println(bannerList);

   }

   @Test
   public void selectAllAblum(){
       List<Album> albumList = albumDao.selectAllAlbumAndChapter();
       for (Album album : albumList) {
           System.out.println(album);
       }
   }

   @Test
   public void queryInformation(){
       Album album = albumDao.selectAlbumInformation(1);
       System.out.println(album);

   }



}

