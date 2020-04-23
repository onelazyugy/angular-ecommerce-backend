package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class HomeItemsResponse extends Response {
    private List<Item> newArrivalItems;
    private List<Item> discountedItems;

    @Builder
    public HomeItemsResponse(Status status, List<Item> newArrivalItems, List<Item> discountedItems) {
        super(status);
        this.newArrivalItems = newArrivalItems;
        this.discountedItems = discountedItems;
    }
}

