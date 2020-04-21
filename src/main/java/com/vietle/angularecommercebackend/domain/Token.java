package com.vietle.angularecommercebackend.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {
    private String accessToken;
}
