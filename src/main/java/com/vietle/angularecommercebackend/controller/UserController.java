package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.domain.request.LoginUserRequest;
import com.vietle.angularecommercebackend.domain.request.RegisterUserRequest;
import com.vietle.angularecommercebackend.domain.response.LoginUserResponse;
import com.vietle.angularecommercebackend.domain.response.RegisterUserResponse;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.UserService;
import com.vietle.angularecommercebackend.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest request) throws EcommerceException {
        LOG.info("/register: " + request.getEmail());
        Validation.validateUserRegistrationInfo(request);
        RegisterUserResponse response = this.userService.register(request);
        ResponseEntity<RegisterUserResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        LOG.info("/register response: " + responseEntity.getBody());
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> login(@RequestBody LoginUserRequest request) throws EcommerceException {
        LOG.info("/login: " + request.getEmail());
        Validation.validateUserLoginInfo(request);
        LoginUserResponse loginResponse = this.userService.login(request);
        ResponseEntity<LoginUserResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.OK);
        LOG.info("/login response: " + responseEntity.getBody());
        return responseEntity;
    }

//    @GetMapping("/find-user/{id}")
//    public ResponseEntity<UserResponse> findUser(@PathVariable int id) throws EcommerceException{
//        UserResponse loginResponse = this.userService.findUserById(id);
//        ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(loginResponse, HttpStatus.OK);
//        return responseEntity;
//    }
}
