package com.sai.automobiles.auth.controller;

import com.sai.automobiles.auth.dto.User;
import com.sai.automobiles.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
       return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.isUserAuthenticated(user);
    }

}
