package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

@Data
public class RegisterUserResponse extends Response {
    private boolean success;
    private String email;

    @Builder
    public RegisterUserResponse(boolean success, String email, Status status) {
        super(status);
        this.success = success;
        this.email = email;
    }
}
