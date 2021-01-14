package com.heroBook.heroBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero,Integer> {
    public Hero findByHeroName(String heroName);
}
