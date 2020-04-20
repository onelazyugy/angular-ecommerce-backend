package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.domain.response.UserResponse;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.UserService;
import com.vietle.angularecommercebackend.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody User user) throws EcommerceException {
        LOG.info("/register: " + user.getEmail());
        Validation.validateUserRegistrationInfo(user);
        UserResponse registerResponse = this.userService.register(user);
        ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(registerResponse, HttpStatus.OK);
        LOG.info("/register response: " + responseEntity.getBody());
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody User user) throws EcommerceException {
        LOG.info("/login: " + user.getEmail());
        Validation.validateUserLoginInfo(user);
        UserResponse loginResponse = this.userService.login(user);
        ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.OK);
        LOG.info("/login response: " + responseEntity.getBody());
        return responseEntity;
    }

    @GetMapping("/find-user/{id}")
    public ResponseEntity<UserResponse> findUser(@PathVariable int id) throws EcommerceException{
        UserResponse loginResponse = this.userService.findUserById(id);
        ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.OK);
        return responseEntity;
    }
}
