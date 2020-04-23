package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

@Data
public class ItemResponse extends Response {
    private Item item;

    @Builder
    public ItemResponse(Status status, Item item) {
        super(status);
        this.item = item;
    }
}
