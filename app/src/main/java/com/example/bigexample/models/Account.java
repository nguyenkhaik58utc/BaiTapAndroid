package com.example.bigexample.models;

public class Account {
    private int idUser;
    private String nameUser;
    private String address;
    private String phone;
    private String yearob;
    private String imgAvatar;
    private String imgBackground;
    private String nameAccounts;
    private String passWord;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYearob() {
        return yearob;
    }

    public void setYearob(String yearob) {
        this.yearob = yearob;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getImgBackground() {
        return imgBackground;
    }

    public void setImgBackground(String imgBackground) {
        this.imgBackground = imgBackground;
    }

    public String getNameAccounts() {
        return nameAccounts;
    }

    public void setNameAccounts(String nameAccounts) {
        this.nameAccounts = nameAccounts;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Account() {
    }

    public Account(int idUser, String nameUser, String address, String phone, String yearob, String imgAvatar, String imgBackground, String nameAccounts, String passWord) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.address = address;
        this.phone = phone;
        this.yearob = yearob;
        this.imgAvatar = imgAvatar;
        this.imgBackground = imgBackground;
        this.nameAccounts = nameAccounts;
        this.passWord = passWord;
    }

    public Account(int idUser, String nameUser, String imgAvatar) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.imgAvatar = imgAvatar;
    }
}
