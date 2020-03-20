package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    @Qualifier("newArrivalItem")
    private ViewItem newArrivalItem;

    public List<Item> retrieveMostViewedItems() throws EcommerceException {
        return this.newArrivalItem.retrieveItems();
    }

}
