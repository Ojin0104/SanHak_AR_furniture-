package com.example.sanhak;

public class Item {
    private String id;
    private String name;
    private String img;
    private String color;
    private String type;
    private String url;
    private String url1;
    private String url2;
    private String price;
    private String price1;
    private String price2;



    public Item(String id, String name, String img, String color, String type, String url, String url1, String url2, String price, String price1, String price2, String brand) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.color = color;
        this.type = type;
        this.url = url;
        this.url1 = url1;
        this.url2 = url2;
        this.price = price;
        this.price1 = price1;
        this.price2 = price2;
        this.brand = brand;
    }
    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;

    public Item(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
