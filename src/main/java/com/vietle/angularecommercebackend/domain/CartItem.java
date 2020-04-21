package com.vietle.angularecommercebackend.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cart")
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartItem {
    @Id
    private int id;
    private String timestamp;
    private Item item;
    private User user;
}
