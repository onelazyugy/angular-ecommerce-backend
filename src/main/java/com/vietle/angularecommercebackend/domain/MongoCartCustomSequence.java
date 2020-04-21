package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "cart_sequence")
public class MongoCartCustomSequence {
    @Id
    private String id;
    private int seq;
}

