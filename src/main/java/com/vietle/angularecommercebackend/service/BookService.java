package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    @Qualifier("bookItem")
    private ViewItem bookItem;

    public List<Item> retrieveBookItems() throws EcommerceException {
        return this.bookItem.retrieveItems();
    }
}
