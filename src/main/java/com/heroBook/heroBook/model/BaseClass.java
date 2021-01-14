package com.heroBook.heroBook.model;

import javax.persistence.*;

@MappedSuperclass
public class BaseClass {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String image;

    private String realName;

    private String heroName;

    private String height;

    private String weight;

    private String specialPower;

    private String intelligence;

    private String strength;

    private String speed;

    private String agility;

    private String description;

    private String story;

    public BaseClass(String image, String realName, String heroName, String height, String weight, String specialPower, String intelligence, String strength, String speed, String agility, String description, String story) {
        this.image = image;
        this.realName = realName;
        this.heroName = heroName;
        this.height = height;
        this.weight = weight;
        this.specialPower = specialPower;
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.agility = agility;
        this.description = description;
        this.story = story;
    }

    public BaseClass() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getAgility() {
        return agility;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", realName='" + realName + '\'' +
                ", heroName='" + heroName + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", specialPower='" + specialPower + '\'' +
                ", intelligence='" + intelligence + '\'' +
                ", strength='" + strength + '\'' +
                ", speed='" + speed + '\'' +
                ", agility='" + agility + '\'' +
                ", description='" + description + '\'' +
                ", story='" + story + '\'' +
                '}';
    }
}
