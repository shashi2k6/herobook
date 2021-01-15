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
        return userService.getFavouriteListByUserName(username);
    }

    @PostMapping("/api/addfavourite")
    public User addUser(@RequestBody String json) throws JsonProcessingException {
        User userObj = getObjectMapper().readValue(json,User.class);
        User userReturn = userService.addFavourite(userObj);
        return userReturn;
    }

    /**
     * Create the dummy user Object for testing
     * @return
     */
   private User createUserObject(){
        List<FavouriteHero> favList = new ArrayList<FavouriteHero>();
        User user = new User("Fan","A registered user who can create Favorites lists of heroes.");
        favList.add(new FavouriteHero("Spidername"));
        user.setFavouriteList(favList);
        return user;
    }

    /**
     * Customized the json deserializer user object.
     * @return
     */
    private ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserializer());
        mapper.registerModule(module);
        return mapper;
    }
}
