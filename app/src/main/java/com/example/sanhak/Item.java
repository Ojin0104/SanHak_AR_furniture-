package com.example.sanhak;

public class Item {
    private String id;
    private String name;
    private String img;
    private String color;
    private String type;
    private String url;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;

    public Item(){}

    public Item(String id, String name, String img, String color, String type, String url,String brand) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.color = color;
        this.type = type;
        this.url = url;
        this.brand=brand;
    }

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
