package com.baizhi.dao;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2018/10/24.
 */
public interface BannerDao {

    public List<Banner> selectAll(@Param("start") int start, @Param("end") int end);

    public int selectCount();

    public void insert(Banner banner);

    public void deleteMany(int id);

    public void update(Banner banner);


}
