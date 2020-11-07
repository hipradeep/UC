package com.example.uc297;

import java.util.List;

public class SubCategoryModel {
  private int subCategoryImg;
  private String subCategoryTitle;
  private String bannerTitle;
  private String bannerDetails;
  private List<SubServicesModel> subServicesModelList;

    public SubCategoryModel(int subCategoryImg, String subCategoryTitle, String bannerTitle, String bannerDetails, List<SubServicesModel> subServicesModelList) {
        this.subCategoryImg = subCategoryImg;
        this.subCategoryTitle = subCategoryTitle;
        this.bannerTitle = bannerTitle;
        this.bannerDetails = bannerDetails;
        this.subServicesModelList = subServicesModelList;
    }

    public List<SubServicesModel> getSubServicesModelList() {
        return subServicesModelList;
    }

    public void setSubServicesModelList(List<SubServicesModel> subServicesModelList) {
        this.subServicesModelList = subServicesModelList;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerDetails() {
        return bannerDetails;
    }

    public void setBannerDetails(String bannerDetails) {
        this.bannerDetails = bannerDetails;
    }

    public int getSubCategoryImg() {
        return subCategoryImg;
    }

    public void setSubCategoryImg(int subCategoryImg) {
        this.subCategoryImg = subCategoryImg;
    }

    public String getSubCategoryTitle() {
        return subCategoryTitle;
    }

    public void setSubCategoryTitle(String subCategoryTitle) {
        this.subCategoryTitle = subCategoryTitle;
    }
}
