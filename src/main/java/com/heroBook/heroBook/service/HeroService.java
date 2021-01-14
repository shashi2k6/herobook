package com.heroBook.heroBook.service;

import com.heroBook.heroBook.model.Hero;
import com.heroBook.heroBook.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    @Autowired
    private HeroRepository heroRepository;

    public List<Hero> getAllHeroes(){
        return heroRepository.findAll();
    }

    public Hero addHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public Optional<Hero> getHeroByName(String heroName) {
        return heroRepository.findByHeroName(heroName);
    }

    public void cleanUpDB() {
        heroRepository.deleteAll();
    }
}
