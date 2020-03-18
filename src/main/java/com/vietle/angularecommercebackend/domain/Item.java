package com.vietle.angularecommercebackend.domain;

import lombok.*;

@Builder
@Data
public class Item {
    private int id;
    private String name;
    private String imgurl;
}
