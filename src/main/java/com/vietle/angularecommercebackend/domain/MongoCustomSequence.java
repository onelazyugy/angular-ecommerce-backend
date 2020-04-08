package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "mongoCustomSequence")
public class MongoCustomSequence {
    @Id
    private String id;
    private int seq;
}