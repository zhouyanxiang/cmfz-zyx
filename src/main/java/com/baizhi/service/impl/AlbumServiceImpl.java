package com.baizhi.service.impl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2018/10/25.
 */
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumDao albumDao;

    @Override
    public List<Album> queryAllAlbumAndChapter() {
        List<Album> albumList = albumDao.selectAllAlbumAndChapter();
        return albumList;

    }

    @Override
    public Album selectAlbumInformation(int id) {
        Album album = albumDao.selectAlbumInformation(id);

        return album;
    }

    @Override
    public void addAlbum(Album album) {
        albumDao.insert(album);
    }
}
