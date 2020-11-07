package com.example.uc297;

public class SubServicesModel {

    public static final int SERVICE_ITEM_TYPE_ONE=0;
    public static final int SERVICE_ITEM_TYPE_TWO=1;
    private int type;

    //////Service layout type one
    private String serviceName;
    private int servicePrice;
    private String freeService;
    private String serviceDetail1;
    private String serviceDetail2;
    private String serviceDetail3;
    private String serviceDetail4;
    private Boolean videoIntro, imageSlider;




    public SubServicesModel(int type, String serviceName, int servicePrice, String freeService, String serviceDetail1, String serviceDetail2, String serviceDetail3, String serviceDetail4, Boolean videoIntro, Boolean imageSlider) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.freeService = freeService;
        this.serviceDetail1 = serviceDetail1;
        this.serviceDetail2 = serviceDetail2;
        this.serviceDetail3 = serviceDetail3;
        this.serviceDetail4 = serviceDetail4;
        this.videoIntro = videoIntro;
        this.imageSlider = imageSlider;
        this.type=type;
    }

    public Boolean getVideoIntro() {
        return videoIntro;
    }

    public void setVideoIntro(Boolean videoIntro) {
        this.videoIntro = videoIntro;
    }

    public Boolean getImageSlider() {
        return imageSlider;
    }

    public void setImageSlider(Boolean imageSlider) {
        this.imageSlider = imageSlider;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceDetail1() {
        return serviceDetail1;
    }

    public void setServiceDetail1(String serviceDetail1) {
        this.serviceDetail1 = serviceDetail1;
    }

    public String getServiceDetail2() {
        return serviceDetail2;
    }

    public void setServiceDetail2(String serviceDetail2) {
        this.serviceDetail2 = serviceDetail2;
    }

    public String getServiceDetail3() {
        return serviceDetail3;
    }

    public void setServiceDetail3(String serviceDetail3) {
        this.serviceDetail3 = serviceDetail3;
    }

    public String getServiceDetail4() {
        return serviceDetail4;
    }

    public void setServiceDetail4(String serviceDetail4) {
        this.serviceDetail4 = serviceDetail4;
    }

    //////Service layout type one


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //////Service layout type two
    private int serviceImage;

    public SubServicesModel(int type, int serviceImage, String serviceName, int servicePrice, String serviceDetail1, String serviceDetail2) {
        this.type = type;
        this.serviceImage=serviceImage;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceDetail1 = serviceDetail1;
        this.serviceDetail2 = serviceDetail2;
    }

    public int getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(int serviceImage) {
        this.serviceImage = serviceImage;
    }
//////Service layout type two
}
