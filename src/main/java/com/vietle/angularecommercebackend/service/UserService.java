package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.Token;
import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.domain.request.RegisterUserRequest;
import com.vietle.angularecommercebackend.domain.response.LoginUserResponse;
import com.vietle.angularecommercebackend.domain.response.RegisterUserResponse;
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

    public LoginUserResponse login(User user) throws EcommerceException {
        String transactionId = UUID.randomUUID().toString();
        User retrievedUser = this.userRepository.retrieve(user);
        String token = jwtHelper.createToken(retrievedUser.getEmail(), retrievedUser.getRoles());
        Token accessToken = Token.builder().accessToken(token).build();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        LoginUserResponse loginUserResponse = LoginUserResponse.builder().status(status).success(true).token(accessToken).build();
        return loginUserResponse;
    }

    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) throws EcommerceException {
        String transactionId = UUID.randomUUID().toString();
        User retrievedUser = this.userRepository.save(registerUserRequest.getUser());
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        RegisterUserResponse registerUserResponse = RegisterUserResponse.builder().email(retrievedUser.getEmail()).success(true).status(status).build();
        return registerUserResponse;
    }

//    public UserResponse findUserById(int id) throws EcommerceException{
//        String transactionId = UUID.randomUUID().toString();
//        User retrievedUser = this.userRepository.retrieve(id);
//        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
//        //TODO: retrievedUser
//        UserResponse response = UserResponse.builder().user(retrievedUser).status(status).token(null).build();
//        return response;
//    }
}
