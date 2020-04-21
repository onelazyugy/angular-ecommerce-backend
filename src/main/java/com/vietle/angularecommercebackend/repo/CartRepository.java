package com.vietle.angularecommercebackend.repo;

import com.vietle.angularecommercebackend.domain.CartItem;
import com.vietle.angularecommercebackend.exception.EcommerceException;

public interface CartRepository {
    CartItem add(CartItem cartItem) throws EcommerceException;
    boolean delete(CartItem cartItem) throws EcommerceException;
    boolean update(CartItem cartItem) throws EcommerceException;
}
