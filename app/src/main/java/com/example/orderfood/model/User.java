package com.example.orderfood.model;

/**
 * @author yuliiamelnyk on 10/06/2020
 * @project OrderFood
 */
public class User {
    private String name;
    private String password;
    private String phone;

    public  User(){

    }

    public User(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
