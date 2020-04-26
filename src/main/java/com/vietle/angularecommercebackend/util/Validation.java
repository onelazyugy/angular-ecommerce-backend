package com.vietle.angularecommercebackend.util;

import com.vietle.angularecommercebackend.domain.request.LoginUserRequest;
import com.vietle.angularecommercebackend.domain.request.RegisterUserRequest;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.util.StringUtils;

public class Validation {
    private Validation(){}

    public static void validateUserLoginInfo(LoginUserRequest request) throws EcommerceException {
        if(request == null) {
            throw new EcommerceException("login information is missing", 400);
        } else if(StringUtils.isEmpty(request.getEmail()) || StringUtils.isEmpty(request.getPassword())) {
            throw new EcommerceException("login information is missing", 400);
        }
    }

    public static void validateUserRegistrationInfo(RegisterUserRequest request) throws EcommerceException {
        if(request == null) {
            throw new EcommerceException("registration information is missing", 400);
        } else if(StringUtils.isEmpty(request.getEmail()) || StringUtils.isEmpty(request.getPassword()) || StringUtils.isEmpty(request.getConfirmPassword())) {
            throw new EcommerceException("all fields are required", 400);
        } else if(!request.getPassword().trim().equals(request.getConfirmPassword().trim())) {
            throw new EcommerceException("password does not match", 400);
        }
    }
}
