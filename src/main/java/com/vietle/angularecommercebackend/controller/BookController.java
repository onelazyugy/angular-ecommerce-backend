package com.vietle.angularecommercebackend.controller;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.BookResponse;
import com.vietle.angularecommercebackend.domain.ElectronicResponse;
import com.vietle.angularecommercebackend.domain.Item;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.BookService;
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
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ResponseEntity<BookResponse> retrieveItemsForHome() throws EcommerceException {
        List<Item> electronicItems = this.bookService.retrieveBookItems();
        String transactionId = UUID.randomUUID().toString();
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();

        BookResponse bookResponse = BookResponse.builder().bookItems(electronicItems).status(status).build();
        ResponseEntity<BookResponse> responseEntity = new ResponseEntity<>(bookResponse, HttpStatus.OK);
        return responseEntity;
    }
}
