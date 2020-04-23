package com.vietle.angularecommercebackend.domain.response;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class BookResponse extends Response {
    private List<Item> bookItems;

    @Builder
    public BookResponse(Status status, List<Item> bookItems) {
        super(status);
        this.bookItems = bookItems;
    }
}
