package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    @Qualifier("mostViewedItem")
    private ViewItem mostViewedItem;

    @Autowired
    @Qualifier("recentlyViewedItem")
    private ViewItem recentlyViewedItem;

    public List<Item> retrieveMostViewedItems() throws EcommerceException {
        return this.mostViewedItem.retrieveItems();
    }

    public List<Item> retrieveRecentlyViewedItems() throws EcommerceException{
        return this.recentlyViewedItem.retrieveItems();
    }
}
