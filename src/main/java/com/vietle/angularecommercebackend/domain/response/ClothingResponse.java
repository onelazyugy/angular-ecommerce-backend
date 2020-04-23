package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ClothingResponse extends Response{
    private List<Item> clothingItems;

    @Builder
    public ClothingResponse(Status status, List<Item> clothingItems) {
        super(status);
        this.clothingItems = clothingItems;
    }
}
