package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/10/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/queryAllUser")
    @ResponseBody
    public List<User> queryAllUser() {

        List<User> users = userService.queryAllUser();
      /*  for (User user : users) {
            System.out.println(user);
        }*/
        return users;

    }

    @RequestMapping("/queryUserByTime")
    @ResponseBody
    public Map queryUserByTime() {

        Map map = userService.selectUserByTime();

        return map;
    }

    @RequestMapping("/queryAllChinaMap")
    @ResponseBody
    public List<Map> queryAllChinaMap() {

        List<Map> data = userService.selectAllUserDTO();
        return data;

    }


}
