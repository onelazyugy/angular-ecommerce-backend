package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.Token;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginUserResponse extends Response{
    private boolean success;
    private Token token;

    @Builder
    public LoginUserResponse(boolean success, Token token, Status status) {
        super(status);
        this.success = success;
        this.token = token;
    }
}
