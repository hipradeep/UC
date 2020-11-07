package com.example.uc297;

public class CategoryModel {
    private int SERVICE_NO;
    private int categoryImg;
    private String categoryTitle;
    private String categoryDescription;
    private String featureOffers;

    public CategoryModel(int SERVICE_NO, int categoryImg, String categoryTitle, String categoryDescription) {
        this.categoryImg = categoryImg;
        this.SERVICE_NO=SERVICE_NO;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
    }

    public CategoryModel(int SERVICE_NO, int categoryImg, String categoryTitle, String featureOffers, String categoryDescription) {
        this.SERVICE_NO = SERVICE_NO;
        this.categoryImg = categoryImg;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
        this.featureOffers = featureOffers;
    }


    public String getFeatureOffers() {
        return featureOffers;
    }

    public void setFeatureOffers(String featureOffers) {
        this.featureOffers = featureOffers;
    }

    public int getSERVICE_NO() {
        return SERVICE_NO;
    }

    public void setSERVICE_NO(int SERVICE_NO) {
        this.SERVICE_NO = SERVICE_NO;
    }

    public int getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(int categoryImg) {
        this.categoryImg = categoryImg;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
