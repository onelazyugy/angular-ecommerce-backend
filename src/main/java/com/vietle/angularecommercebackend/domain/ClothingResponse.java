package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClothingResponse {
    private Status status;
    private List<Item> clothingItems;
}
