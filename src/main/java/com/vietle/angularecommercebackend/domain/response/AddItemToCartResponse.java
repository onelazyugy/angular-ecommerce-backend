package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.CartItem;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
public class AddItemToCartResponse extends Response {
    private CartItem cartItem;
    private String timestamp;

    @Builder
    public AddItemToCartResponse(Status status, CartItem cartItem, String timestamp) {
        super(status, null);
        this.cartItem = cartItem;
        this.timestamp = timestamp;
    }
}
