package com.baizhi.service.impl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2018/10/23.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    public AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        Admin admin1 = adminDao.selectOne(admin);
        System.out.println("dao++"+admin1+"+admin+"+admin);
        return admin1;
    }
}
