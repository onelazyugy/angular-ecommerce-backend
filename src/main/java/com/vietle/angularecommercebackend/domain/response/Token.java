package com.vietle.angularecommercebackend.domain.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Token {
    private String accessToken;
}
