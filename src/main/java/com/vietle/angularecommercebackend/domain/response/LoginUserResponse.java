package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.Token;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginUserResponse extends Response{
    private boolean success;
    private String email;
    private int id;
    private Token token;

    @Builder
    public LoginUserResponse(boolean success, String email, int id, Token token, Status status) {
        super(status);
        this.success = success;
        this.email = email;
        this.id = id;
        this.token = token;
    }
}