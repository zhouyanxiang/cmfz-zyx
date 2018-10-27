package com.baizhi.service;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;

import java.util.List;

/**
 * Created by admin on 2018/10/25.
 */
public interface AlbumService {

    public List<Album> queryAllAlbumAndChapter();

    public Album selectAlbumInformation(int id);

    public void  addAlbum(Album album);
}
