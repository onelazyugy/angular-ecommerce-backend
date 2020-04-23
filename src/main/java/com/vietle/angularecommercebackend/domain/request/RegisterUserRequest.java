package com.vietle.angularecommercebackend.domain.request;

import com.vietle.angularecommercebackend.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterUserRequest {
    private User user;
    private String timestamp;
}
