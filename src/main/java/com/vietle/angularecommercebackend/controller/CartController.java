package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.domain.request.AddItemToCartRequest;
import com.vietle.angularecommercebackend.domain.response.AddItemToCartResponse;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/item")
    public ResponseEntity<AddItemToCartResponse> addItemToCard(@RequestBody AddItemToCartRequest addItemToCartRequest) throws EcommerceException {
        AddItemToCartResponse addItemToCartResponse = cartService.addItemToCard(addItemToCartRequest);
        ResponseEntity<AddItemToCartResponse> responseEntity = new ResponseEntity<>(addItemToCartResponse, HttpStatus.OK);
        return responseEntity;
    }
}
