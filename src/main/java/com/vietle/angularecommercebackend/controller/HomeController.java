package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.domain.HomeItemsResponse;
import com.vietle.angularecommercebackend.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping("/home/items")
    public ResponseEntity<HomeItemsResponse> retrieveItemsForHome() {

    }
}
