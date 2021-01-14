package com.heroBook.heroBook.service;

import com.heroBook.heroBook.model.Villain;
import com.heroBook.heroBook.repository.VillainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VillainService {

    @Autowired
    private VillainRepository villainRepository;

    public List<Villain> getAllVillains(){
        return villainRepository.findAll();
    }

    public Villain addVillain(Villain villain) {
        return villainRepository.save(villain);
    }

    public Optional<Villain> getVillainByName(String villainName) {
        return villainRepository.findByRealName(villainName);
    }

    public void cleanUpDB() {
        villainRepository.deleteAll();
    }

}
