package com.example.uc297;

import java.util.List;

public class HomePageModel {


    public static final int BANNER_SLIDER = 0;
    public static final int STRIP_AD_BANNER = 1;
    public static final int AVAILABLE_SERVICE_IN_AREA_VIEW = 2;
    public static final int GRID_PRODUCT_VIEW = 3;
    public static final int SPOTLIGHT_SLIDER = 4;


    private int type;

    private boolean customerView;

    ////////////////////////////// slider banner


    public HomePageModel(int type, boolean customerView, String title, String description, List<CategoryModel> categoryModelList) {
        this.type = type;
        this.customerView = customerView;
        this.title = title;
        this.categoryModelList = categoryModelList;
        this.description = description;
    }

    public boolean isCustomerView() {
        return customerView;
    }

    public void setCustomerView(boolean customerView) {
        this.customerView = customerView;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }



    //////////////////////////// slider banner


    ////////////////////////////ad strip
    private int adStripImg;
    private String bgColor;

    public HomePageModel(int type, int adStripImg, String bgColor) {
        this.type = type;
        this.adStripImg = adStripImg;
        this.bgColor = bgColor;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public int getAdStripImg() {
        return adStripImg;
    }

    public void setAdStripImg(int adStripImg) {
        this.adStripImg = adStripImg;
    }
    ////////////////////// ad strip


    ///////////////////// available service
    private String title;
    private List<CategoryModel> categoryModelList;

    public HomePageModel(int type, String title, List<CategoryModel> categoryModelList) {
        this.type = type;
        this.title = title;
        this.categoryModelList = categoryModelList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategoryModel> getCategoryModelList() {
        return categoryModelList;
    }

    public void setCategoryModelList(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }
    ///////////////////// available service

    ///////////////////////grid service
    private String description;
     private int SERVICE_NO;
    public HomePageModel(int type, int SERVICE_NO, String title,String description, List<CategoryModel> categoryModelList) {
        this.type = type;
        this.title = title;
        this.SERVICE_NO=SERVICE_NO;
        this.categoryModelList = categoryModelList;
        this.description = description;
    }

    public int getSERVICE_NO() {
        return SERVICE_NO;
    }

    public void setSERVICE_NO(int SERVICE_NO) {
        this.SERVICE_NO = SERVICE_NO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    ///////////////////////grid service



}


