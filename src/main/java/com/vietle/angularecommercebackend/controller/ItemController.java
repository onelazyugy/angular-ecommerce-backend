package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.response.ItemResponse;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.ItemService;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/item-detail/{id}/{category}")
    public ResponseEntity<ItemResponse> retrieveItemDetial(@PathVariable int id, @PathVariable int category, HttpServletRequest req) throws EcommerceException {
        Item item = this.itemService.retrieveItem(id, category, req);
        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        ItemResponse itemResponse = ItemResponse.builder().item(item).status(status).build();
        ResponseEntity<ItemResponse> responseEntity = new ResponseEntity<>(itemResponse, HttpStatus.OK);
        return responseEntity;
    }
}
