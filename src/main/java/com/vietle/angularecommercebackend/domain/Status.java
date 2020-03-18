package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Status {
    private String message;
    private String transactionId;
    private int statusCd;
}
