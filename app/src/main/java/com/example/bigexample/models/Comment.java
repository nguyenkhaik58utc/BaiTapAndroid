package com.example.bigexample.models;

public class Comment {
    private int id;
    private String nameUserCmt;
    private String contentCmt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUserCmt() {
        return nameUserCmt;
    }

    public void setNameUserCmt(String nameUserCmt) {
        this.nameUserCmt = nameUserCmt;
    }

    public String getContentCmt() {
        return contentCmt;
    }

    public void setContentCmt(String contentCmt) {
        this.contentCmt = contentCmt;
    }

    public Comment(int id, String nameUserCmt, String contentCmt) {
        this.id = id;
        this.nameUserCmt = nameUserCmt;
        this.contentCmt = contentCmt;
    }
}
