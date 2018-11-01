package com.baizhi.restful;

import com.baizhi.entity.Artical;
import com.baizhi.service.RestfulService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by admin on 2018/10/30.
 */

@Controller
@RequestMapping("/restful")
public class Restful {

    @Autowired
    RestfulService restfulService;

    @RequestMapping("/first_page")
    @ResponseBody
    public Map first_page(int uid,String type) {
        System.out.println("uid+++"+uid+"-----type+++"+type);
        Map map = restfulService.queryFisrstPage(uid,type );
        return map;
    }


    @RequestMapping("/queryArtical")
    @ResponseBody
    public Artical queryArtical(String uid, int id, HttpServletRequest request){
        System.out.println("uid+++"+uid+"id++++"+id);

        String user_id= uid;

        Artical artical = restfulService.selectArtical(id,user_id);
        /*request.setAttribute("artical",artical)*/;
        return  artical;

    }


}
