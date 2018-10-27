package com.baizhi.dao;

import com.baizhi.entity.Album;

import java.util.List;

/**
 * Created by admin on 2018/10/25.
 */
public interface AlbumDao {

    public List<Album> selectAllAlbumAndChapter();


    public Album selectAlbumInformation(int id);


    public void insert(Album album);
}
