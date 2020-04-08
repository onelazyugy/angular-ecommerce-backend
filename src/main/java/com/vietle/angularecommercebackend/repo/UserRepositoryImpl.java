package com.vietle.angularecommercebackend.repo;

import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User save(User user) throws EcommerceException {
        user.setPassword(EcommerceUtil.hash(user.getPassword()));
        User savedUser = mongoTemplate.save(user);
        savedUser.setPassword(null);
        return savedUser;
    }

    @Override
    public boolean delete(int id) throws EcommerceException {
        return false;
    }

    @Override
    public boolean update(User user) throws EcommerceException {
        return false;
    }

    @Override
    public User retrieve(int id) throws EcommerceException {
        return null;
    }

    @Override
    public User retrieve(User user) throws EcommerceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(user.getEmail().trim()));
        query.addCriteria(Criteria.where("password").is(EcommerceUtil.hash(user.getPassword().trim())));
        List<User> foundUsers = this.mongoTemplate.find(query, User.class);
        User foundUser = foundUsers.stream().findFirst().orElseThrow(() -> new EcommerceException("invalid login!", 500));
        foundUser.setPassword(null);
        return foundUser;
    }
}
