package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.domain.UserResponse;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.repo.UserRepository;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody User user) throws EcommerceException {
        LOG.info("/register: " + user.getEmail());
        User savedUser = this.userRepository.save(user);
        //TODO: validation
        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        UserResponse userResponse = UserResponse.builder().user(savedUser).status(status).success(true).build();
        ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(userResponse, HttpStatus.OK);
        LOG.info("/register response: " + responseEntity.getBody());
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody User user) throws EcommerceException {
        LOG.info("/login: " + user.getEmail());
        User retrievedUser = this.userRepository.retrieve(user);
        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        UserResponse userResponse = UserResponse.builder().user(retrievedUser).status(status).success(true).build();
        ResponseEntity<UserResponse> responseEntity = new ResponseEntity<>(userResponse, HttpStatus.OK);
        LOG.info("/login response: " + responseEntity.getBody());
        return responseEntity;
    }

    @GetMapping("/find-user/{id}")
    public void findUser(@PathVariable int id) throws EcommerceException{
        User user = this.userRepository.retrieve(id);
    }

}
