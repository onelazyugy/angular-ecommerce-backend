package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.exception.EcommerceException;

import java.util.List;

public interface ViewItem {
    List<Item> retrieveItems() throws EcommerceException;
}
