package com.vietle.angularecommercebackend.repo;

import com.vietle.angularecommercebackend.domain.Role;
import com.vietle.angularecommercebackend.domain.User;
import com.vietle.angularecommercebackend.exception.EcommerceException;
import com.vietle.angularecommercebackend.security.JwtTokenProvider;
import com.vietle.angularecommercebackend.service.MongoSequenceService;
import com.vietle.angularecommercebackend.util.EcommerceUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Value("${security.jwt.token.secret-key}")
    private String secretKey;
    @Value("${security.jwt.token.expire-length}")
    private long validityInMilliseconds;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoSequenceService mongoSequenceService;


    public String createToken(String username, List<Role> roles) {

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()//
                .setClaims(claims)//
                .setIssuedAt(now)//
                .setExpiration(validity)//
                .signWith(SignatureAlgorithm.HS256, secretKey)//
                .compact();
    }

    @Override
    public User save(User user) throws EcommerceException {
        int nextSequence = mongoSequenceService.getNextSequence("mongoCustomSequence");
        user.setId(nextSequence);
        user.setPassword(EcommerceUtil.hash(user.getPassword()));
        user.setConfirmPassword(null);
        User savedUser = mongoTemplate.save(user);
        //TODO: check savedUser and handle exception
        savedUser.setPassword(null);
        //token
        String token = this.createToken(savedUser.getEmail(), user.getRoles());
        System.out.println("GENERATED TOKEN: " + token);
        //
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
        //token
        String token = this.createToken(foundUser.getEmail(), foundUser.getRoles());
        System.out.println("GENERATED TOKEN: " + token);
        foundUser.setToken(token);
        return foundUser;
    }
}
