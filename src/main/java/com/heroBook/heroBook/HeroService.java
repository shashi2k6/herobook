package com.heroBook.heroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Hero> getHeroByName(String heroName) {
        List<Hero> heroList = getAllHeroes();
        List<Hero> heroByNameList = heroList
                .stream()
                .filter(hero -> hero.getHeroName().equals(heroName))
                .collect(Collectors.toList());
        return heroByNameList;
    }
}
