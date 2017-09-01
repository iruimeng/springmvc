package com.springmvc.model;

/**
 * Created by MT on 2017/3/2.
 */
public class Blog {
    private int id;
    private String title;
    private String content;
    private String ctime;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCtime() {
        return ctime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String toString() {
        return title + "————" + content;
    }
}
