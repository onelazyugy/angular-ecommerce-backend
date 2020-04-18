package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserResponse extends Response {
    private User user;

    @Builder
    public UserResponse(Status status, Token token, User user) {
        super(status, token);
        this.user = user;
    }
}
