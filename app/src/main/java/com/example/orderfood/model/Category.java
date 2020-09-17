package com.example.orderfood.model;

/**
 * @author yuliiamelnyk on 16/09/2020
 * @project OrderFood
 */
public class Category {
    private String Name;
    private String Image;

    public Category() {
    }

    public Category(String name, String image) {
        this.Name = name;
        this.Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }
}
