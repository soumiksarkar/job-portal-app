package com.homeassignment.jobportalapp.controller;

import com.homeassignment.jobportalapp.model.request.EmployerCreateRequest;
import com.homeassignment.jobportalapp.model.response.EmployerResponse;
import com.homeassignment.jobportalapp.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/employers")
public class EmployerController {

    private EmployerService employerService;

    EmployerController(@Autowired EmployerService EmployerService){
        this.employerService = EmployerService;
    }

    @GetMapping
    public ResponseEntity<List<EmployerResponse>> getEmployers(){
        return ResponseEntity.ok(employerService.getEmployers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerResponse> loadEmployer(@PathVariable Long id){
        return ResponseEntity.ok(employerService.loadEmployer(id));
    }

    @PostMapping
    public ResponseEntity createEmployer(@RequestBody EmployerCreateRequest request){
        EmployerResponse newFreelancer = employerService.createEmployer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFreelancer);
    }
}
