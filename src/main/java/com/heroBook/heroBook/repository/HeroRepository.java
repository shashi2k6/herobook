package com.heroBook.heroBook.repository;

import com.heroBook.heroBook.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {

    public Hero findByHeroName(String heroName);

}
