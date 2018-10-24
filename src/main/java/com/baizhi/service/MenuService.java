package com.baizhi.service;

import com.baizhi.entity.Menu;

import java.util.List;

/**
 * Created by admin on 2018/10/23.
 */
public interface MenuService {

    public List<Menu> queryAllByCategory();
}
