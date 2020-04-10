package com.vietle.angularecommercebackend.util;

import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.util.StringUtils;

public class Validation {
    private Validation(){}

    public static void validateUserLoginInfo(User user) throws EcommerceException {
        if(user == null) {
            throw new EcommerceException("login information is missing", 400);
        } else if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword())) {
            throw new EcommerceException("login information is missing", 400);
        }
    }

    public static void validateUserRegistrationInfo(User user) throws EcommerceException {
        if(user == null) {
            throw new EcommerceException("registration information is missing", 400);
        } else if(StringUtils.isEmpty(user.getEmail()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getConfirmPassword())) {
            throw new EcommerceException("all fields are required", 400);
        } else if(!user.getPassword().trim().equals(user.getConfirmPassword().trim())) {
            throw new EcommerceException("password does not match", 400);
        }
    }
}
