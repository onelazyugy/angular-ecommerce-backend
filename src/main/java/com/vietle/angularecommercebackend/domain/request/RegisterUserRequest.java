package com.vietle.angularecommercebackend.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String timestamp;
}
