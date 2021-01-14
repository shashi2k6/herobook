package com.heroBook.heroBook.controller;

import com.heroBook.heroBook.model.Hero;
import com.heroBook.heroBook.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<Hero> hero = heroService.getHeroByName(heroName);
        if(hero.isPresent())
            return new ResponseEntity(hero, HttpStatus.OK);
        else
            return new ResponseEntity("Hero doesn't exist", HttpStatus.OK);
    }

    @DeleteMapping("/api/cleanuphero")
    public void cleanUpDB(){
         heroService.cleanUpDB();
    }

}
