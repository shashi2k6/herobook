package com.heroBook.heroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Hero getHeroByName(String heroName) {
        return heroRepository.findByHeroName(heroName);
    }

    public void cleanUpDB() {
        heroRepository.deleteAll();
    }
}
