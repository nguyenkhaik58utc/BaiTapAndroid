package com.example.bigexample.models;

public class Message {
    private int idMessage;
    private int idUser;
    private int nameUser;
    private String content;
    private String Date;
    private String image;

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getNameUser() {
        return nameUser;
    }

    public void setNameUser(int nameUser) {
        this.nameUser = nameUser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Message() {
    }

    public Message(int idUser, String content) {
        this.idUser = idUser;
        this.content = content;
    }

    public Message(String content, String image) {
        this.content = content;
        this.image = image;
    }

    public Message(int idUser, String content, String image) {
        this.idUser = idUser;
        this.content = content;
        this.image = image;
    }
}
