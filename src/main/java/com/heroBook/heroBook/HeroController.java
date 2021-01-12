package com.heroBook.heroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/heroByName")
    public List<Hero> getHeroByName(@RequestParam String heroName){
        return heroService.getHeroByName(heroName);
    }

}
