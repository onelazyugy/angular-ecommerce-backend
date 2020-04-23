package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ElectronicResponse extends Response {
    private List<Item> electronicItems;

    @Builder
    public ElectronicResponse(Status status, List<Item> electronicItems) {
        super(status);
        this.electronicItems = electronicItems;
    }
}
