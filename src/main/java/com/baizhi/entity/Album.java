package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/10/25.
 */
public class Album {

    private int id;
    private String title;
    private String coverImg;
    private int count;//大小
    private int score;//评分
    private String author;
    private String broadCast;//播音
    private String brief;//简介
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date publishDate;//上传时间

    private List<Chapter> children;

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", count=" + count +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCast='" + broadCast + '\'' +
                ", brief='" + brief + '\'' +
                ", publishDate=" + publishDate +
                ", children=" + children +
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

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCast() {
        return broadCast;
    }

    public void setBroadCast(String broadCast) {
        this.broadCast = broadCast;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public List<Chapter> getChildren() {
        return children;
    }

    public void setChildren(List<Chapter> children) {
        this.children = children;
    }

    public Album() {

    }

    public Album(int id, String title, String coverImg, int count, int score, String author, String broadCast, String brief, Date publishDate, List<Chapter> children) {

        this.id = id;
        this.title = title;
        this.coverImg = coverImg;
        this.count = count;
        this.score = score;
        this.author = author;
        this.broadCast = broadCast;
        this.brief = brief;
        this.publishDate = publishDate;
        this.children = children;
    }
}
