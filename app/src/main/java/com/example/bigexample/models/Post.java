package com.example.bigexample.models;

public class Post {
    private int imageUserPost;
    private String nameUserPost;
    private String addressPost;
    private String phoneUserPost;
    private String describe;
    private int imageAddress;
    private int imageAddress2;

    public Post(int i, String s, String s1, String s2, String s3) {
    }

    public int getImageUserPost() {
        return imageUserPost;
    }

    public void setImageUserPost(int imageUserPost) {
        this.imageUserPost = imageUserPost;
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

    public int getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(int imageAddress) {
        this.imageAddress = imageAddress;
    }


    public Post(int imageUserPost, String nameUserPost, String addressPost, String phoneUserPost, String describe, int imageAddress) {
        this.imageUserPost = imageUserPost;
        this.nameUserPost = nameUserPost;
        this.addressPost = addressPost;
        this.phoneUserPost = phoneUserPost;
        this.describe = describe;
        this.imageAddress = imageAddress;
    }
}
