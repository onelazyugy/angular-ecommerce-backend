package com.vietle.angularecommercebackend.domain;

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
