package com.baizhi.service;

import com.baizhi.entity.Artical;

import java.util.Map;

/**
 * Created by admin on 2018/10/30.
 */
public interface RestfulService {

    public Map queryFisrstPage(int uid, String type);

    public Artical selectArtical(int id,String uid);
}
