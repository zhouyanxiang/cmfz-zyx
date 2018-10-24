package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin on 2018/10/23.
 */

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/queryAllByCategory")
    @ResponseBody
    public List<Menu> queryAllByCategory() {

        List<Menu> menuList = menuService.queryAllByCategory();


        return menuList;

    }

}
