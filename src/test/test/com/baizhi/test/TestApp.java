package com.baizhi.test;

import com.baizhi.CmfzApp;
import com.baizhi.dao.BannerDao;
import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Menu;
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
       System.out.println(list);

   }

   @Test
   public void queryAllBanner(){

       List<Banner> bannerList = bannerDao.selectAll(1,5);

       System.out.println(bannerList);

   }


}

    /*mvn install:install-file -DgroupId=com.google.code -DartifactId=kaptcha -Dversion=2.3.2 -Dfile=f:/kaptcha-2.3.2.jar -Dpackaging=jar -DgeneratePom=true
*/