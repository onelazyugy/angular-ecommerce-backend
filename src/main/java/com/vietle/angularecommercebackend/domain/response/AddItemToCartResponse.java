package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

@Data
public class AddItemToCartResponse extends Response {
    private boolean success;

    @Builder
    public AddItemToCartResponse(boolean success, Status status) {
        super(status);
        this.success = success;
    }
}
