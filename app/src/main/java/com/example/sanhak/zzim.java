package com.example.sanhak;

public class zzim {
    public String img="";
    public String name="";
    public String price="";
    public boolean color=true;
public zzim(){}
    public zzim(String img, String name, String price,boolean color) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.color=color;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
