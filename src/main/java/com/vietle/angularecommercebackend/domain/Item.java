package com.vietle.angularecommercebackend.domain;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
public class Item {
    private int id;
    private String name;
    private String imgurl;
    private BigDecimal price;
    private int category;
    private String description;
}
