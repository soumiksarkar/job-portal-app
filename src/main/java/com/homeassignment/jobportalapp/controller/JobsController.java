package com.homeassignment.jobportalapp.controller;

import com.homeassignment.jobportalapp.model.request.ApplyJobRequest;
import com.homeassignment.jobportalapp.model.request.PostJobRequest;
import com.homeassignment.jobportalapp.model.response.AppliedJobResponse;
import com.homeassignment.jobportalapp.model.response.JobsResponse;
import com.homeassignment.jobportalapp.model.response.Response;
import com.homeassignment.jobportalapp.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/jobs")
public class JobsController {
    
    private JobsService jobsService;

    JobsController(@Autowired JobsService JobsService){
        this.jobsService = JobsService;
    }

    @GetMapping
    public ResponseEntity<List<JobsResponse>> getJobs(){
        return ResponseEntity.ok(jobsService.getJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobsResponse> loadJob(@PathVariable Long id){
        return ResponseEntity.ok(jobsService.loadJob(id));
    }

    @PostMapping
    public ResponseEntity postNewJob(@RequestBody PostJobRequest request){
        JobsResponse newFreelancer = jobsService.postJob(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFreelancer);
    }

    @PostMapping("/apply")
    public ResponseEntity<Response> applyJob(@RequestBody ApplyJobRequest request){
        jobsService.applyJob(request);
        return ResponseEntity.ok(Response.builder().build());
    }

    @GetMapping("/apply/{applcntId}")
    public ResponseEntity<List<AppliedJobResponse>> getAppliedJobs(@PathVariable Long applcntId){
        return ResponseEntity.ok(jobsService.getAppliedJobs(applcntId));
    }

}
