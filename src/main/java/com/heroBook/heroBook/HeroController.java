package com.heroBook.heroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public ResponseEntity getHeroByName(@RequestParam String heroName) throws Exception {
        Hero hero = heroService.getHeroByName(heroName);
        if(hero!=null)
            return new ResponseEntity(hero, HttpStatus.OK);
        else
            return new ResponseEntity("Hero doesn't exist", HttpStatus.OK);
    }

    @DeleteMapping("/api/cleanup")
    public void cleanUpDB(){
         heroService.cleanUpDB();
    }

}
