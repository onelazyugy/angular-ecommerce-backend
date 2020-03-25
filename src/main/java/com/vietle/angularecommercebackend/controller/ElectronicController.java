package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.ElectronicResponse;
import com.vietle.angularecommercebackend.domain.HomeItemsResponse;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.ElectronicService;
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
public class ElectronicController {
    @Autowired
    private ElectronicService electronicService;

    @GetMapping("/electronic")
    public ResponseEntity<ElectronicResponse> retrieveItemsForHome() throws EcommerceException {
        List<Item> electronicItems = this.electronicService.retrieveElectronicItems();
        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();

        ElectronicResponse electronicResponse = ElectronicResponse.builder().electronicItems(electronicItems).status(status).build();
        ResponseEntity<ElectronicResponse> responseEntity = new ResponseEntity<>(electronicResponse, HttpStatus.OK);
        return responseEntity;
    }
}
