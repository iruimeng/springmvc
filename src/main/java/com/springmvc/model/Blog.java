package com.springmvc.model;

import java.sql.Date;

/**
 * Created by MT on 2017/3/2.
 */
public class Blog {
    private int id;
    private String title;
    private String content;
    private Date ctime;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getCtime() {
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

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
