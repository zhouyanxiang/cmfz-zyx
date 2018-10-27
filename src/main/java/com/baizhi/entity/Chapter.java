package com.baizhi.entity;

/**
 * Created by admin on 2018/10/25.
 */
public class Chapter {

    private String id;
    private String title;
    private String url;
    private double size;
    private long duration;
    private int pid;


    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", duration=" + duration +
                ", pid=" + pid +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Chapter() {

    }

    public Chapter(String id, String title, String url, double size, long duration, int pid) {

        this.id = id;
        this.title = title;
        this.url = url;
        this.size = size;
        this.duration = duration;
        this.pid = pid;
    }
}
