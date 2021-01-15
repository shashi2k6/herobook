package com.heroBook.heroBook.controller;

import com.heroBook.heroBook.model.FavouriteHero;
import com.heroBook.heroBook.model.User;
import com.heroBook.heroBook.service.UserService;
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
        //return us ;
        return createUserObject();
    }

    @PostMapping("/api/addfavourite")
    public User addUser(@RequestBody User user){
        User userR = userService.addFavourite(user);
        return userR;
    }

   private User createUserObject(){
        List<FavouriteHero> favList = new ArrayList<FavouriteHero>();
        User user = new User();
        user.setName("Fan");
        user.setRole("A registered user who can create Favorites lists of heroes.");
        //favList.add(new FavouriteHero("Spidername"));
        //user.setFavouriteList(favList);
        return user;
    }

}
