package com.heroBook.heroBook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero extends BaseClass {

    @Id @GeneratedValue(strategy= GenerationType.AUTO) int id;
    private String heroName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Hero() {
    }

    public Hero(String heroName) {
        this.heroName = heroName;
    }

    public Hero(String image, String heroName, String height, String weight, String specialPower, String intelligence, String strength, String speed, String agility, String description, String story) {
        this.heroName = heroName;
    }
}
