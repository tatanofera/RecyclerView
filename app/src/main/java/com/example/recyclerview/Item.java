package com.example.recyclerview;

public class Item {
    private int imgResId;
    private String title;
    private String comments;

    public Item(int imgResId, String title, String comments) {
        this.imgResId = imgResId;
        this.title = title;
        this.comments = comments;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getTitle() {
        return title;
    }

    public String getComments() {
        return comments;
    }
}