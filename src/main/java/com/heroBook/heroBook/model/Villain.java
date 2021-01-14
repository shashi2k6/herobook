package com.heroBook.heroBook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Villain extends BaseClass {

    @Id @GeneratedValue(strategy= GenerationType.AUTO) int id;
    private String archRival;

    public Villain() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArchRival() {
        return archRival;
    }

    public void setArchRival(String archRival) {
        this.archRival = archRival;
    }


}
