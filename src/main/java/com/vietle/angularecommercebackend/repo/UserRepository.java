package com.vietle.angularecommercebackend.repo;

import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.exception.EcommerceException;

public interface UserRepository {
    User save(User user) throws EcommerceException;
    boolean delete(int id) throws EcommerceException;
    boolean update(User user) throws EcommerceException;
    User retrieve(int id) throws EcommerceException;
    User retrieve(User user) throws EcommerceException;
}
