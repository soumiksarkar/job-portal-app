package com.homeassignment.jobportalapp.model.request;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
