package com.baizhi.service.impl;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by admin on 2018/10/24.
 */
@Transactional
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerDao bannerDao;

    @Override
    public Map queryAllBanner(int page,int rows) {

        Map map = new HashMap();
        int start = page * rows - rows;
        int end = page * rows;

        List<Banner> bannerList = bannerDao.selectAll(start,end);

        int i = bannerDao.selectCount();

        map.put("rows", bannerList);
        map.put("total", i);
        return map;
    }

    @Override
    public void add(Banner banner) {


        bannerDao.insert(banner);
    }

    @Override
    public void deleteMany(int id) {
        bannerDao.deleteMany(id);
    }

    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);
    }


}
