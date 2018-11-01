package com.baizhi.test;

import com.baizhi.service.RestfulService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by admin on 2018/10/30.
 */
public class TestRestFui extends TestObject {

    @Autowired
    RestfulService service;

    @Test
    public void testRestful(){
        Map map = service.queryFisrstPage(19,"wen1");
        for (Object o : map.values()) {
            System.out.println(o);
        }


    }
}
