package com.heroBook.heroBook.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.heroBook.heroBook.model.FavouriteHero;
import com.heroBook.heroBook.model.User;
import com.heroBook.heroBook.service.UserService;
import com.heroBook.heroBook.util.UserDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/userfavourlist")
    public User getUserFavouriteList(@RequestParam String username){
        User us  = userService.getFavouriteListByUserName(username);
        return us ;
        //return createUserObject();
    }

    @Autowired
    ObjectMapper objectMapper;


    @PostMapping("/api/addfavourite")
    public User addUser(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserializer());
        mapper.registerModule(module);

        User u = mapper.readValue(json,User.class);
        User userR = userService.addFavourite(u);
        return userR;
    }


   private User createUserObject(){
        List<FavouriteHero> favList = new ArrayList<FavouriteHero>();
        User user = new User("","");
        user.setName("Fan");
        user.setRole("A registered user who can create Favorites lists of heroes.");
        favList.add(new FavouriteHero("Spidername"));
        user.setFavouriteList(favList);
        return user;
    }

}
