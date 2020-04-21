package com.vietle.angularecommercebackend.repo;

import com.vietle.angularecommercebackend.domain.CartItem;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.MongoCartSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepositoryImpl implements CartRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoCartSequenceService mongoCartSequenceService;

    @Override
    public CartItem add(CartItem cartItem) throws EcommerceException {
        int sequence = mongoCartSequenceService.getNextSequence("sequence");
        cartItem.setId(sequence);
        CartItem cartItemSaved = mongoTemplate.save(cartItem);
        return cartItemSaved;
    }

    @Override
    public boolean delete(CartItem cartItem) throws EcommerceException {
        return false;
    }

    @Override
    public boolean update(CartItem cartItem) throws EcommerceException {
        return false;
    }
}
