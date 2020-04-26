package com.vietle.angularecommercebackend.domain.request;

import com.vietle.angularecommercebackend.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserRequest {
    private String email;
    private String password;
}
