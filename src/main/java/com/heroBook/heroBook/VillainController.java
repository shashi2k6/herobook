package com.heroBook.heroBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/api/cleanuphero")
    public void cleanUpDB(){
        villainService.cleanUpDB();
    }
}
