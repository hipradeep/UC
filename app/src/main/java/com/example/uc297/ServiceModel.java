package com.example.uc297;

import java.util.List;

public class ServiceModel {

    private String ServiceCategoryName;
    private String ServiceCategoryBannerName;
    private String BannerDescriptions;
    private List<SubServicesModel> servicesModelList;


    public ServiceModel(String serviceCategoryName, String serviceCategoryBannerName, String bannerDescriptions, List<SubServicesModel> servicesModelList) {
        ServiceCategoryName = serviceCategoryName;
        ServiceCategoryBannerName = serviceCategoryBannerName;
        BannerDescriptions = bannerDescriptions;
        this.servicesModelList = servicesModelList;
    }

    public String getServiceCategoryName() {
        return ServiceCategoryName;
    }

    public void setServiceCategoryName(String serviceCategoryName) {
        ServiceCategoryName = serviceCategoryName;
    }

    public String getServiceCategoryBannerName() {
        return ServiceCategoryBannerName;
    }

    public void setServiceCategoryBannerName(String serviceCategoryBannerName) {
        ServiceCategoryBannerName = serviceCategoryBannerName;
    }

    public String getBannerDescriptions() {
        return BannerDescriptions;
    }

    public void setBannerDescriptions(String bannerDescriptions) {
        BannerDescriptions = bannerDescriptions;
    }

    public List<SubServicesModel> getServicesModelList() {
        return servicesModelList;
    }

    public void setServicesModelList(List<SubServicesModel> servicesModelList) {
        this.servicesModelList = servicesModelList;
    }
}


