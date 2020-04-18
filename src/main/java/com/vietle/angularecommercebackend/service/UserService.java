package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.domain.response.Token;
import com.vietle.angularecommercebackend.domain.response.UserResponse;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.repo.UserRepository;
import com.vietle.angularecommercebackend.security.JwtHelper;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    private static Logger LOG = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserRepository userRepository;

    public UserResponse login(User user) throws EcommerceException {
        String transactionId = UUID.randomUUID().toString();
        User retrievedUser = this.userRepository.retrieve(user);
        String token = jwtHelper.createToken(retrievedUser.getEmail(), retrievedUser.getRoles());
        Token accessToken = Token.builder().accessToken(token).build();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        //TODO: retrievedUser
        UserResponse response = UserResponse.builder().user(retrievedUser).status(status).token(accessToken).build();
        return response;
    }

    public UserResponse register(User user) throws EcommerceException {
        String transactionId = UUID.randomUUID().toString();
        User retrievedUser = this.userRepository.save(user);
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        //TODO: retrievedUser
        UserResponse response = UserResponse.builder().user(retrievedUser).status(status).token(null).build();
        return response;
    }

    public UserResponse findUserById(int id) throws EcommerceException{
        String transactionId = UUID.randomUUID().toString();
        User retrievedUser = this.userRepository.retrieve(id);
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        //TODO: retrievedUser
        UserResponse response = UserResponse.builder().user(retrievedUser).status(status).token(null).build();
        return response;
    }
}
