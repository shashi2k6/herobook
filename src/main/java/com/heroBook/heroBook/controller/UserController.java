package com.heroBook.heroBook.controller;

import com.heroBook.heroBook.model.User;
import com.heroBook.heroBook.service.UserServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServie userServie;

    @GetMapping("/api/user")
    public User getUserFavouriteList(){
        User user = new User();
        List favList = new ArrayList<String>();
        favList.add("Spiderman");
       // user.setFavouriteList(favList);
        return user;
    }

}
