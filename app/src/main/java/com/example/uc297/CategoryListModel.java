package com.example.uc297;

public class CategoryListModel {

    private int SERVICE_NO;
    private int ListImg;
    private String ListName;
    private String categoryDesc;

    public CategoryListModel(int SERVICE_NO, int listImg, String listName, String categoryDesc) {
        this.SERVICE_NO = SERVICE_NO;
        ListImg = listImg;
        ListName = listName;
        this.categoryDesc = categoryDesc;
    }

    public int getSERVICE_NO() {
        return SERVICE_NO;
    }

    public void setSERVICE_NO(int SERVICE_NO) {
        this.SERVICE_NO = SERVICE_NO;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public int getListImg() {
        return ListImg;
    }

    public void setListImg(int listImg) {
        ListImg = listImg;
    }

    public String getListName() {
        return ListName;
    }

    public void setListName(String listName) {
        ListName = listName;
    }
}

