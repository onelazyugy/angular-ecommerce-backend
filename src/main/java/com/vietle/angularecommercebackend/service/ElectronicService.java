package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicService {
    @Autowired
    @Qualifier("electronicItem")
    private ViewItem electronicItem;

    public List<Item> retrieveElectronicItems() throws EcommerceException {
        return this.electronicItem.retrieveItems();
    }
}
