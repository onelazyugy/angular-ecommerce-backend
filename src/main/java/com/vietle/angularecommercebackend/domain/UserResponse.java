package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Status status;
    private User user;
    private boolean success;
    private String token;
}
