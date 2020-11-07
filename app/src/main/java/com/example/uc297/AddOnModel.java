package com.example.uc297;

public class AddOnModel {
    private int img;
    private String addOnTitle;
    private String addOnPrice;

    public AddOnModel(int img, String addOnTitle, String addOnPrice) {
        this.img = img;
        this.addOnTitle = addOnTitle;
        this.addOnPrice = addOnPrice;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getAddOnTitle() {
        return addOnTitle;
    }

    public void setAddOnTitle(String addOnTitle) {
        this.addOnTitle = addOnTitle;
    }

    public String getAddOnPrice() {
        return addOnPrice;
    }

    public void setAddOnPrice(String addOnPrice) {
        this.addOnPrice = addOnPrice;
    }
}
