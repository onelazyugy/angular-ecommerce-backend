package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class StoreItemsResponse extends Response{
    private List<Item> mostViewedItems;
    private List<Item> recentlyViewedItems;

    @Builder
    public StoreItemsResponse(Status status, List<Item> mostViewedItems, List<Item> recentlyViewedItems) {
        super(status);
        this.mostViewedItems = mostViewedItems;
        this.recentlyViewedItems = recentlyViewedItems;
    }
}
