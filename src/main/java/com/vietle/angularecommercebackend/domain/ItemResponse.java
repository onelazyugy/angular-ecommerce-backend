package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemResponse {
    private Status status;
    private Item item;
}
