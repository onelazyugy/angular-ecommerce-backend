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
    private MongoCartSequenceService seq;

    @Override
    public boolean add(CartItem cartItem) {
        int sequence = seq.getNextSequence("sequence");
        cartItem.setId(sequence);
        CartItem savedCartItem = mongoTemplate.save(cartItem);
        if(savedCartItem == null) {
            return false;
        }
        return true;
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
