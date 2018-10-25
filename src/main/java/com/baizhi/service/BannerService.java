package com.baizhi.service;


import com.baizhi.entity.Banner;

import java.util.Map;

/**
 * Created by admin on 2018/10/24.
 */
public interface BannerService {

    public Map queryAllBanner(int page, int rows);

    public void add(Banner banner);

    public void deleteMany(int id);

    public void update(Banner banner);
}
