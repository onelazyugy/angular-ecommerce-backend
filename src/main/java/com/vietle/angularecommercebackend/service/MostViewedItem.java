package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MostViewedItem implements ViewItem{
    @Override
    public List<Item> retrieveItems() {
        // TODO us the json file in resource folder
        List<Item> mostViewedItems = new ArrayList<>(6);
        Item item = Item.builder().id(1).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 1").build();
        Item item2 = Item.builder().id(2).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 2").build();
        Item item3 = Item.builder().id(3).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 3").build();
        Item item4 = Item.builder().id(4).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 4").build();
        Item item5 = Item.builder().id(5).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 5").build();
        Item item6 = Item.builder().id(6).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 6").build();
        mostViewedItems.add(item); mostViewedItems.add(item2); mostViewedItems.add(item3);
        mostViewedItems.add(item4); mostViewedItems.add(item5); mostViewedItems.add(item6);
        return mostViewedItems;
    }
}
