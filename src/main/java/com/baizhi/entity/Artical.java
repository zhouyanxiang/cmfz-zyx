package com.baizhi.entity;

import java.util.Date;

/**
 * Created by admin on 2018/10/30.
 */
public class Artical {

    private int id;
    private String title;
    private String insertImg;
    private String content;
    private Date publishDate;

    @Override
    public String toString() {
        return "Artical{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", insertImg='" + insertImg + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInsertImg() {
        return insertImg;
    }

    public void setInsertImg(String insertImg) {
        this.insertImg = insertImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Artical() {

    }

    public Artical(int id, String title, String insertImg, String content, Date publishDate) {

        this.id = id;
        this.title = title;
        this.insertImg = insertImg;
        this.content = content;
        this.publishDate = publishDate;
    }
}
