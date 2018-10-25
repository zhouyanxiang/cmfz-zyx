package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
            return  true;
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


}
