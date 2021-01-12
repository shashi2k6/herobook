package com.heroBook.heroBook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroController {



    @GetMapping("/api/hero")
    public List<Hero> getAllHeores(){
        List<Hero> heroList = new ArrayList<Hero>();
        heroList.add(new Hero("Superman"));
        return heroList;
    }
}
