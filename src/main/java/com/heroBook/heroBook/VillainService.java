package com.heroBook.heroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Villain getVillainByName(String villainName) {
        return villainRepository.findByRealName(villainName);
    }

    public void cleanUpDB() {
        villainRepository.deleteAll();
    }

}
