package com.baizhi.test;

import com.baizhi.dao.UserDao;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


/**
 * Created by admin on 2018/10/29.
 */
public class TestUser extends TestObject {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @Test
    public void TestCount() {

        Map map = userService.selectUserByTime();
        /*for (Object o : map.keySet()) {
            System.out.println(o);
        }*/




    }
}
