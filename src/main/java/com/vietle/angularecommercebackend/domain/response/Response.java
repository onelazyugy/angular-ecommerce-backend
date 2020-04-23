package com.vietle.angularecommercebackend.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vietle.angularecommercebackend.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Status status;
}
