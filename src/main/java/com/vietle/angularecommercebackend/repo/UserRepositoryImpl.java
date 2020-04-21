package com.vietle.angularecommercebackend.repo;

import com.vietle.angularecommercebackend.domain.Role;
import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.service.MongoUserSequenceService;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoUserSequenceService mongoUserSequenceService;
    private static Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public User save(User user) throws EcommerceException {
        int nextSequence = mongoUserSequenceService.getNextSequence("sequence");
        user.setId(nextSequence);
        user.setPassword(EcommerceUtil.hash(user.getPassword()));
        user.setConfirmPassword(null);

        // TODO:
        List<Role> roleList = new ArrayList<>(1);
        roleList.add(Role.ROLE_USER); // hard code for now, need a UI in the admin screen to set role
        user.setRoles(roleList); // hard code for now, need a UI in the admin screen to set role

        User savedUser = mongoTemplate.save(user);
        //TODO: check savedUser and handle exception
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
    public User retrieve(String email) throws EcommerceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email.trim()));
        List<User> foundUsers = this.mongoTemplate.find(query, User.class);
        User foundUser = foundUsers.stream().findFirst().orElseThrow(() -> new EcommerceException("invalid login!", 400));
        return foundUser;
    }

    @Override
    public User retrieve(User user) throws EcommerceException {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(user.getEmail().trim()));
        query.addCriteria(Criteria.where("password").is(EcommerceUtil.hash(user.getPassword().trim())));
        List<User> foundUsers = this.mongoTemplate.find(query, User.class);
        User foundUser = foundUsers.stream().findFirst().orElseThrow(() -> new EcommerceException("invalid login!", 400));
        foundUser.setPassword(null);
        return foundUser;
    }
}
