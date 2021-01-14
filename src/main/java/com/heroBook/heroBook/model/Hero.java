package com.heroBook.heroBook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero extends BaseClass {

    public Hero() {
        super();
    }

    public Hero(String image, String realName, String heroName, String height, String weight, String specialPower, String intelligence, String strength, String speed, String agility, String description, String story) {
          super(image, realName,heroName, height, weight, specialPower, intelligence, strength, speed, agility, description, story);
    }
    
}
