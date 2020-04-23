package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.response.ClothingResponse;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.ClothingService;
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
@RequestMapping("/api/v1/clothing")
public class ClothingController {
    @Autowired
    private ClothingService clothingService;

    @GetMapping("/items")
    public ResponseEntity<ClothingResponse> retrieveItemsForClothing() throws EcommerceException {
        List<Item> clothingItems = this.clothingService.retrieveClothingItems();
        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();

        ClothingResponse clothingResponse = ClothingResponse.builder().clothingItems(clothingItems).status(status).build();
        ResponseEntity<ClothingResponse> responseEntity = new ResponseEntity<>(clothingResponse, HttpStatus.OK);
        return responseEntity;
    }
}
