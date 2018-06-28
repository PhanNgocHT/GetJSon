package com.example.ngocpt.getjson.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ngoc.pt on 28/06/2018.
 */

public class Products implements Serializable {
    @SerializedName("id_product")
    private  int idProduct;
    @SerializedName("product_name")
    private  String productName;
    @SerializedName("decription")
    private  String decription;
    @SerializedName("price")
    private  String price;
    @SerializedName("thumnail")
    private  String thumnail;

    public Products() {
    }

    public Products(int idProduct, String productName, String decription, String price, String thumnail) {
        this.idProduct = idProduct;
        this.productName = productName;
        this.decription = decription;
        this.price = price;
        this.thumnail = thumnail;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumnail() {
        return thumnail;
    }

    public void setThumnail(String thumnail) {
        this.thumnail = thumnail;
    }
}
