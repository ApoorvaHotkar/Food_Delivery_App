package com.example.fooddeliveryapp;

public class CartModelClass {
    private String Quantity;
    private String imageName;
    private String imagePrice;
    private String imageurl;

    public CartModelClass() {
    }

    public CartModelClass(String quantity, String name, String price, String imageUrl) {
        Quantity = quantity;
        imageName = name;
        imagePrice = price;
        imageurl = imageUrl;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
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
