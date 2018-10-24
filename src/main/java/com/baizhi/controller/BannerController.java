package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public List<Banner> queryAllBanner(){
        List<Banner> bannerList = bannerService.queryAllBanner();


        return bannerList;
    }

}
