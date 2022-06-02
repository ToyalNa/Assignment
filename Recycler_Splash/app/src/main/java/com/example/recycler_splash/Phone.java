package com.example.recycler_splash;

public class Phone {
    private int imgID;
    private String name;
    private String phone;

    public Phone(int imgID, String name, String phone) {
        this.imgID = imgID;
        this.name = name;
        this.phone = phone;
    }

    public int getImgID() {
        return imgID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
