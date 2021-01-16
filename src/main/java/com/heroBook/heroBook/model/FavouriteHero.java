package com.heroBook.heroBook.model;

import javax.persistence.*;

@Entity
public class FavouriteHero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favourite_list")
    @SequenceGenerator(name = "favourite_list", sequenceName = "favourite_list", allocationSize = 100,initialValue = 1)
    private int id;

    private String name;

    public FavouriteHero() {
    }

    public FavouriteHero(String name) {
        this.name = name;
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
}
