package com.example.bigexample.models;

public class Post {
    private int idPost;
    private int idUser;
    private String imageUserPost;
    private String nameUserPost;
    private String addressPost;
    private String pricePost;
    private String describe;
    private int numberLike;
    private int numberComment;
    private String imageAddress;
    private String imageAddress2;

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getImageUserPost() {
        return imageUserPost;
    }

    public void setImageUserPost(String imageUserPost) {
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

    public String getPricePost() {
        return pricePost;
    }

    public void setPricePost(String pricePost) {
        this.pricePost = pricePost;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(int numberLike) {
        this.numberLike = numberLike;
    }

    public int getNumberComment() {
        return numberComment;
    }

    public void setNumberComment(int numberComment) {
        this.numberComment = numberComment;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getImageAddress2() {
        return imageAddress2;
    }

    public void setImageAddress2(String imageAddress2) {
        this.imageAddress2 = imageAddress2;
    }


    public Post(int idPost, int idUser, String imageUserPost, String nameUserPost, String addressPost, String pricePost, String describe, int numberLike, int numberComment, String imageAddress, String imageAddress2) {
        this.idPost = idPost;
        this.idUser = idUser;
        this.imageUserPost = imageUserPost;
        this.nameUserPost = nameUserPost;
        this.addressPost = addressPost;
        this.pricePost = pricePost;
        this.describe = describe;
        this.numberLike = numberLike;
        this.numberComment = numberComment;
        this.imageAddress = imageAddress;
        this.imageAddress2 = imageAddress2;
    }

    public Post(int idPost, int idUser, String addressPost, String pricePost, String describe, String imageAddress, String imageAddress2) {
        this.idPost = idPost;
        this.idUser = idUser;
        this.addressPost = addressPost;
        this.pricePost = pricePost;
        this.describe = describe;
        this.imageAddress = imageAddress;
        this.imageAddress2 = imageAddress2;
    }

    public Post(int idPost, int numberLike) {
        this.idPost = idPost;
        this.numberLike = numberLike;
    }




}
