package com.vietle.angularecommercebackend.util;

import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.domain.request.LoginUserRequest;
import com.vietle.angularecommercebackend.domain.request.RegisterUserRequest;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.util.StringUtils;

public class Validation {
    private Validation(){}

    public static void validateUserLoginInfo(LoginUserRequest request) throws EcommerceException {
        if(request == null || request.getUser() == null) {
            throw new EcommerceException("login information is missing", 400);
        } else if(StringUtils.isEmpty(request.getUser().getEmail()) || StringUtils.isEmpty(request.getUser().getPassword())) {
            throw new EcommerceException("login information is missing", 400);
        }
    }

    public static void validateUserRegistrationInfo(RegisterUserRequest request) throws EcommerceException {
        if(request == null || request.getUser() == null) {
            throw new EcommerceException("registration information is missing", 400);
        } else if(StringUtils.isEmpty(request.getUser().getEmail()) || StringUtils.isEmpty(request.getUser().getPassword()) || StringUtils.isEmpty(request.getUser().getConfirmPassword())) {
            throw new EcommerceException("all fields are required", 400);
        } else if(!request.getUser().getPassword().trim().equals(request.getUser().getConfirmPassword().trim())) {
            throw new EcommerceException("password does not match", 400);
        }
    }
}
