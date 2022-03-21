package com.homeassignment.jobportalapp.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class Response<T> {
    private ErrorResponse err;
    private T data;
}
