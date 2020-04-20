package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HomeItemsResponse {
    private Status status;
    private List<Item> newArrivalItems;
    private List<Item> discountedItems;
}
