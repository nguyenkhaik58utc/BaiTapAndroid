package com.example.bigexample.models;

public class Comment {
    private int id;
    private  int idUserCmt;
    private String imgUserCmt;
    private String nameUserCmt;
    private String contentCmt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUserCmt() {
        return idUserCmt;
    }

    public void setIdUserCmt(int idUserCmt) {
        this.idUserCmt = idUserCmt;
    }



    public Comment(int id, int idUserCmt, String imgUserCmt, String nameUserCmt, String contentCmt) {
        this.id = id;
        this.idUserCmt = idUserCmt;
        this.imgUserCmt = imgUserCmt;
        this.nameUserCmt = nameUserCmt;
        this.contentCmt = contentCmt;
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

    public Comment(int id, int idUserCmt, String nameUserCmt, String contentCmt) {
        this.id = id;
        this.idUserCmt = idUserCmt;
        this.nameUserCmt = nameUserCmt;
        this.contentCmt = contentCmt;
    }

    public Comment(int id, int idUserCmt, String contentCmt) {
        this.id = id;
        this.idUserCmt = idUserCmt;
        this.contentCmt = contentCmt;
    }
}
