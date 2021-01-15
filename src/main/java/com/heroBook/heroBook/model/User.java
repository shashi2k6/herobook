package com.heroBook.heroBook.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;

public class User {

    private int id;
    private String name;
    private String role;

    private List<String> favouriteList;

    public List<String> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(List<String> favouriteList) {
        this.favouriteList = favouriteList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
