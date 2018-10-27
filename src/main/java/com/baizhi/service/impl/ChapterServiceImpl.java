package com.baizhi.service.impl;

import com.baizhi.dao.ChapterDao;
import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by admin on 2018/10/25.
 */
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterDao chapterDao;


    @Override
    public void addChapter(Chapter chapter) {

        String uuid = UUID.randomUUID().toString();
        chapter.setId(uuid);
        chapterDao.insert(chapter);
    }
}
