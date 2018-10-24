package com.baizhi.entity;

import java.util.List;

/**
 * Created by admin on 2018/10/23.
 */
public class Menu {

    private int id;
    private String title;
    private int parent_id;
    private String iconCls;
    private String url;
    private List<Menu> list;

    public List<Menu> getList() {
        return list;
    }

    public void setList(List<Menu> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parent_id=" + parent_id +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", list=" + list +
                '}';
    }

    public Menu(List<Menu> list) {
        this.list = list;
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

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu() {
    }

    public Menu(int id, String title, int parent_id, String iconCls, String url) {

        this.id = id;
        this.title = title;
        this.parent_id = parent_id;
        this.iconCls = iconCls;
        this.url = url;
    }
}
