package com.heroBook.heroBook.repository;

import com.heroBook.heroBook.model.Villain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillainRepository extends JpaRepository<Villain,Integer> {
    public Villain findByRealName(String realName);
}