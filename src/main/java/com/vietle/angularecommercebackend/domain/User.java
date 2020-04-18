package com.vietle.angularecommercebackend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "users")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String confirmPassword;
    private String signupDate;
    private Order order;
    private List<Role> roles;
}
