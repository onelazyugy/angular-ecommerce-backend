package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.response.HomeItemsResponse;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.HomeService;
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
@RequestMapping("/api/v1/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/items")
    public ResponseEntity<HomeItemsResponse> retrieveItemsForHome() throws EcommerceException {
        List<Item> newArrivalItems = this.homeService.retrieveNewArrivalItems();
        List<Item> discountedItems = this.homeService.retrieveDiscountedItems();
        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        HomeItemsResponse homeItemsResponse = HomeItemsResponse.builder().newArrivalItems(newArrivalItems).discountedItems(discountedItems).status(status).build();
        ResponseEntity<HomeItemsResponse> responseEntity = new ResponseEntity<>(homeItemsResponse, HttpStatus.OK);
        return responseEntity;
    }
}
