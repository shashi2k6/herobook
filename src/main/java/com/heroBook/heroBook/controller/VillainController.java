package com.heroBook.heroBook.controller;

import com.heroBook.heroBook.model.Villain;
import com.heroBook.heroBook.service.VillainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VillainController {

    @Autowired
    private VillainService villainService;

    @GetMapping("/api/villain")
    public List<Villain> getAllVillains(){
        return villainService.getAllVillains();
    }

    @PostMapping("/api/villain")
    public Villain addHero(@RequestBody Villain villain){
        return villainService.addVillain(villain);
    }

    @GetMapping("/api/villainByName")
    public ResponseEntity getVillainByName(@RequestParam String villainName) throws Exception {
        Villain villain = villainService.getVillainByName(villainName);
        if(villain!=null)
            return new ResponseEntity(villain, HttpStatus.OK);
        else
            return new ResponseEntity("Villain doesn't exist", HttpStatus.OK);
    }

    @DeleteMapping("/api/cleanupvillian")
    public void cleanUpDB(){
        villainService.cleanUpDB();
    }
}
