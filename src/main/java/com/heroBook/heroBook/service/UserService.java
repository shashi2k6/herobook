package com.heroBook.heroBook.service;

import com.heroBook.heroBook.model.User;
import com.heroBook.heroBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getFavouriteListByUserName(String name) {
        return userRepository.findByName(name);
    }

    public User addFavourite(User user) {
        return userRepository.save(user);
    }
}
