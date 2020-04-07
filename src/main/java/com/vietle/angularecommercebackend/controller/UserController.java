package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        mongoTemplate.save(user);
        System.out.println("success!");
    }

    @GetMapping("/find-user")
    public void findUser(@RequestBody User user) {
        System.out.println();
    }

}
