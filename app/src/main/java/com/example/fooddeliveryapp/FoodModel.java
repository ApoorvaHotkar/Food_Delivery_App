package com.example.fooddeliveryapp;

public class FoodModel {
    private String imageName;
    private String imagePrice;
    private String imageurl;

    public FoodModel() {
    }

    public FoodModel(String imageName, String imagePrice, String imageurl) {
        this.imageName = imageName;
        this.imagePrice = imagePrice;
        this.imageurl = imageurl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePrice() {
        return imagePrice;
    }

    public void setImagePrice(String imagePrice) {
        this.imagePrice = imagePrice;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}


