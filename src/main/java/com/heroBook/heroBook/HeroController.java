package com.heroBook.heroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroController {


    @Autowired
    private HeroService heroService;

    @GetMapping("/api/hero")
    public List<Hero> getAllHeores(){
        return heroService.getAllHeroes();
    }

    @PostMapping("/api/hero")
    public Hero addHero(@RequestBody Hero hero){
        return heroService.addHero(hero);
    }
}
