package com.heroBook.heroBook.model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String role;

    public User() {
    }

    @OneToMany(cascade = CascadeType.ALL)
    private List<FavouriteHero> favouriteList;

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public User(String name, String role, List<FavouriteHero> favouriteList) {
        this.name = name;
        this.role = role;
        this.favouriteList = favouriteList;
    }

    public List<FavouriteHero> getFavouriteList() {
        return favouriteList;
    }

    public void setFavouriteList(List<FavouriteHero> favouriteList) {
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


}
