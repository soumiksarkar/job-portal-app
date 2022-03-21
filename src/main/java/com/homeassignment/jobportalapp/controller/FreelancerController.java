package com.homeassignment.jobportalapp.controller;

import com.homeassignment.jobportalapp.model.request.FreelancerCreateRequest;
import com.homeassignment.jobportalapp.model.response.FreelancerResponse;
import com.homeassignment.jobportalapp.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/freelancers")
public class FreelancerController {

    private FreelancerService freelancerService;

    FreelancerController(@Autowired FreelancerService freelancerService){
        this.freelancerService = freelancerService;
    }

    @GetMapping
    public ResponseEntity<List<FreelancerResponse>>  getFreelancers(){
        return ResponseEntity.ok(freelancerService.getFreelancers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreelancerResponse>  loadFreelancer(@PathVariable Long id){
        return ResponseEntity.ok(freelancerService.loadFreelancer(id));
    }

    @PostMapping
    public ResponseEntity createFreelancer(@RequestBody FreelancerCreateRequest request){
        FreelancerResponse newFreelancer = freelancerService.createFreelancer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFreelancer);
    }


}
