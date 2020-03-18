package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.domain.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecentlyViewedItem implements ViewItem{
    @Override
    public List<Item> retrieveItems() {
        // TODO us the json file in resource folder
        List<Item> recentlyViewedItems = new ArrayList<>(6);
        Item recentlyViewedItems1 = Item.builder().id(1).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 1").build();
        Item recentlyViewedItems2 = Item.builder().id(2).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 2").build();
        Item recentlyViewedItems3 = Item.builder().id(3).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 3").build();
        Item recentlyViewedItems4 = Item.builder().id(4).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 4").build();
        Item recentlyViewedItems5 = Item.builder().id(5).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 5").build();
        Item recentlyViewedItems6 = Item.builder().id(6).imgurl("https://semantic-ui.com/images/wireframe/image.png").name("item name 6").build();
        recentlyViewedItems.add(recentlyViewedItems1); recentlyViewedItems.add(recentlyViewedItems2); recentlyViewedItems.add(recentlyViewedItems3);
        recentlyViewedItems.add(recentlyViewedItems4); recentlyViewedItems.add(recentlyViewedItems5); recentlyViewedItems.add(recentlyViewedItems6);
        return recentlyViewedItems;
    }
}
