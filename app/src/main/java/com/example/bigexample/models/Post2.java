package com.example.bigexample.models;

public class Post2 {
    private int idUserPost;
    private String nameUserPost;
    private String addressPost;
    private String phoneUserPost;
    private String describe;

    public int getIdUserPost() {
        return idUserPost;
    }

    public void setIdUserPost(int idUserPost) {
        this.idUserPost = idUserPost;
    }

    public String getNameUserPost() {
        return nameUserPost;
    }

    public void setNameUserPost(String nameUserPost) {
        this.nameUserPost = nameUserPost;
    }

    public String getAddressPost() {
        return addressPost;
    }

    public void setAddressPost(String addressPost) {
        this.addressPost = addressPost;
    }

    public String getPhoneUserPost() {
        return phoneUserPost;
    }

    public void setPhoneUserPost(String phoneUserPost) {
        this.phoneUserPost = phoneUserPost;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Post2() {
    }

    public Post2(int idUserPost, String nameUserPost, String addressPost, String phoneUserPost, String describe) {
        this.idUserPost = idUserPost;
        this.nameUserPost = nameUserPost;
        this.addressPost = addressPost;
        this.phoneUserPost = phoneUserPost;
        this.describe = describe;
    }
}
