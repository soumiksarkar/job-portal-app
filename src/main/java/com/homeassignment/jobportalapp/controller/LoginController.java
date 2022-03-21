package com.homeassignment.jobportalapp.controller;

import com.homeassignment.jobportalapp.model.request.LoginRequest;
import com.homeassignment.jobportalapp.model.response.EmployerResponse;
import com.homeassignment.jobportalapp.model.response.FreelancerResponse;
import com.homeassignment.jobportalapp.service.EmployerService;
import com.homeassignment.jobportalapp.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private FreelancerService freelancerService;

    private EmployerService employerService;

    LoginController(@Autowired FreelancerService freelancerService, @Autowired EmployerService employerService){
        this.freelancerService = freelancerService;
        this.employerService = employerService;
    }

    @PostMapping("/freelancer")
    public ResponseEntity<FreelancerResponse> freelancerLogin(@RequestBody LoginRequest request){
        FreelancerResponse response = freelancerService.authenticate(request.getUsername(), request.getPassword());
        if(null != response){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FreelancerResponse.builder().build());
        }
    }

    @PostMapping("/employer")
    public ResponseEntity<EmployerResponse> employerLogin(@RequestBody LoginRequest request){
        EmployerResponse response = employerService.authenticate(request.getUsername(), request.getPassword());
        if(null != response){
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(EmployerResponse.builder().build());
        }
    }
}
