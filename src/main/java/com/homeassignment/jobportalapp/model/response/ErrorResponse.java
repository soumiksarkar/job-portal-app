package com.homeassignment.jobportalapp.model.response;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ErrorResponse {
    private String errCode;
    private String errMsg;
}
