package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.StoreItemsResponse;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.StoreService;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/store")
    public ResponseEntity<StoreItemsResponse> retrieveItemsForStore() throws EcommerceException {
        List<Item> mostViewedItems = this.storeService.retrieveMostViewedItems();
        List<Item> recentlyViewedItems = this.storeService.retrieveRecentlyViewedItems();

        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();

        StoreItemsResponse storeItemsResponse = StoreItemsResponse.builder().status(status).mostViewedItems(mostViewedItems).recentlyViewedItems(recentlyViewedItems).build();
        ResponseEntity<StoreItemsResponse> responseEntity = new ResponseEntity<>(storeItemsResponse, HttpStatus.OK);
        return responseEntity;
    }
}
