package com.vietle.angularecommercebackend.domain.request;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddItemToCartRequest {
    private Item item;
    private User user;
    private String timestamp;
}
