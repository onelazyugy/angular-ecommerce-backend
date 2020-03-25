package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingService {
    @Autowired
    @Qualifier("clothingItem")
    private ViewItem clothingItem;

    public List<Item> retrieveClothingItems() throws EcommerceException {
        return this.clothingItem.retrieveItems();
    }
}
