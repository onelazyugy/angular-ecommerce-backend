package com.vietle.angularecommercebackend.service;

import com.vietle.angularecommercebackend.Constant;
import com.vietle.angularecommercebackend.domain.CartItem;
import com.vietle.angularecommercebackend.domain.Status;
import com.vietle.angularecommercebackend.domain.request.AddItemToCartRequest;
import com.vietle.angularecommercebackend.domain.response.AddItemToCartResponse;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.repo.CartRepository;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public AddItemToCartResponse addItemToCard(AddItemToCartRequest addItemToCartRequest) throws EcommerceException {
        String transactionId = UUID.randomUUID().toString();
        CartItem cartItem = CartItem.builder().user(addItemToCartRequest.getUser())
                                            .item(addItemToCartRequest.getItem())
                                            .timestamp(EcommerceUtil.getTimestamp()).build();
        if(!cartRepository.add(cartItem)) {
            throw new EcommerceException("unable to add item to cart", 500);
        }
        Status status = Status.builder().statusCd(200).message(Constant.SUCCESS).transactionId(transactionId).timestamp(EcommerceUtil.getTimestamp()).build();
        AddItemToCartResponse addItemToCartResponse = AddItemToCartResponse.builder().status(status).success(true).build();
        return addItemToCartResponse;
    }
}
