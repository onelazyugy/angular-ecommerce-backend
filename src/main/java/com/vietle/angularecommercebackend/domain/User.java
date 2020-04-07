package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
@Data
@Builder
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String signupDate;
    private Order order;
}
