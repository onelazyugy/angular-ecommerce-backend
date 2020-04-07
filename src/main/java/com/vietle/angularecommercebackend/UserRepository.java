package com.vietle.angularecommercebackend;

import com.vietle.angularecommercebackend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
