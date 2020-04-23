package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
@Builder
public class Order {
    private String id;
    private List<Item> items;
    private User user;
    private String orderDate;
}
