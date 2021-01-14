package com.heroBook.heroBook.repository;

import com.heroBook.heroBook.model.Villain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VillainRepository extends JpaRepository<Villain,Integer> {

    public Optional<Villain> findByName(String realName);

}
