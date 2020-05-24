package com.example.bigexample.Golobal;

import android.widget.EditText;

public class Golobal {
    public static String getValue(EditText editText) {
        return editText.getText().toString();
    }
    public static int idUser;
    public static String nameUser;
    public static String address;
    public static String phone;
    public static String yearob;
    public static String imgAvatar;
    public static String imgBackground;
    public static String nameAccounts;
    public static String passWord;
    public static int idCmt;
    public static String contentCmt;

    public static int getIdCmt() {
        return idCmt;
    }

    public static void setIdCmt(int idCmt) {
        Golobal.idCmt = idCmt;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        Golobal.idUser = idUser;
    }

    public static String getContentCmt() {
        return contentCmt;
    }

    public static void setContentCmt(String contentCmt) {
        Golobal.contentCmt = contentCmt;
    }

    public static String getNameUser() {
        return nameUser;
    }

    public static void setNameUser(String nameUser) {
        Golobal.nameUser = nameUser;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Golobal.address = address;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        Golobal.phone = phone;
    }

    public static String getYearob() {
        return yearob;
    }

    public static void setYearob(String yearob) {
        Golobal.yearob = yearob;
    }

    public static String getImgAvatar() {
        return imgAvatar;
    }

    public static void setImgAvatar(String imgAvatar) {
        Golobal.imgAvatar = imgAvatar;
    }

    public static String getImgBackground() {
        return imgBackground;
    }

    public static void setImgBackground(String imgBackground) {
        Golobal.imgBackground = imgBackground;
    }

    public static String getNameAccounts() {
        return nameAccounts;
    }

    public static void setNameAccounts(String nameAccounts) {
        Golobal.nameAccounts = nameAccounts;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static void setPassWord(String passWord) {
        Golobal.passWord = passWord;
    }
}
