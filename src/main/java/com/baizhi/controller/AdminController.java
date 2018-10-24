package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2018/10/23.
 */
@Controller
public class AdminController {
    @Autowired
    public AdminService adminService;

    @RequestMapping("/login")
    @ResponseBody
    public  Map login(Admin admin, HttpServletRequest request, String enCode, HttpSession session) {

        Map map = new HashMap();
        Object code1 = session.getAttribute("vrifyCode");
        System.out.println("code1+++"+code1);
        Admin admin1 = adminService.login(admin);
        if(code1.equals(enCode)){

            if(admin1 != null){
             map.put("map",true);

            }else {
                map.put("map",false);

            }
        }else {
            map.put("map",false);
        }

        return map;

    }

}
