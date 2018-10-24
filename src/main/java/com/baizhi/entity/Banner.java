package com.baizhi.entity;

import java.util.Date;

/**
 * Created by admin on 2018/10/24.
 */
public class Banner {

    private  int id;
    private String name;
    private String url;
    private Date createDate;
    private String description;

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", createDate=" + createDate +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Banner() {

    }

    public Banner(int id, String name, String url, Date createDate, String description) {

        this.id = id;
        this.name = name;
        this.url = url;
        this.createDate = createDate;
        this.description = description;
    }
}
