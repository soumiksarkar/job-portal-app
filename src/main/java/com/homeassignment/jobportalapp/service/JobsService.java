package com.homeassignment.jobportalapp.service;

import com.homeassignment.jobportalapp.entity.JobApplctns;
import com.homeassignment.jobportalapp.entity.Jobs;
import com.homeassignment.jobportalapp.model.AppliedJobsModel;
import com.homeassignment.jobportalapp.model.JobsModel;
import com.homeassignment.jobportalapp.model.request.ApplyJobRequest;
import com.homeassignment.jobportalapp.model.request.PostJobRequest;
import com.homeassignment.jobportalapp.model.response.AppliedJobResponse;
import com.homeassignment.jobportalapp.model.response.JobsResponse;
import com.homeassignment.jobportalapp.model.response.Response;
import com.homeassignment.jobportalapp.repository.JobApplctnsRepository;
import com.homeassignment.jobportalapp.repository.JobsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JobsService {

    private JobsRepository jobsRepository;

    private JobApplctnsRepository jobApplctnsRepository;

    JobsService(JobsRepository freelancerRepository, JobApplctnsRepository jobApplctnsRepository){
        this.jobsRepository = freelancerRepository;
        this.jobApplctnsRepository = jobApplctnsRepository;
    }

    public List<JobsResponse> getJobs(){
        List<JobsModel> jobsModels = jobsRepository.findAllJobs();

        return jobsModels
                .stream()
                .map( o -> JobsResponse.fromModel(o))
                .collect(Collectors.toList());
    }

    public JobsResponse loadJob(Long id){
        Optional<Jobs> optional = jobsRepository.findById(id);
        return JobsResponse.fromEntity(optional.get());
    }

    public JobsResponse postJob(PostJobRequest request) {
        final Jobs job = request.toEntity();
        final Jobs newJob = jobsRepository.save(job);
        return JobsResponse.fromEntity(newJob);
    }

    public void applyJob(ApplyJobRequest request){
        final JobApplctns found = jobApplctnsRepository
                .findByApplcntIdAndJobId(request.getApplcntId(), request.getJobId());
        if(null == found){
            final JobApplctns jobApplctns = request.toEntity();
            jobApplctnsRepository.save(jobApplctns);
        } else {
            log.info("Applicant {} already applied for this job {}", request.getApplcntId(), request.getJobId());
        }

    }

    public List<AppliedJobResponse> getAppliedJobs(Long applcntId) {
        List<AppliedJobsModel> result = jobApplctnsRepository.findAllAppliedJobsByApplicantId(applcntId);
        return result.stream()
                .map( o -> AppliedJobResponse.fromModel(o))
                .collect(Collectors.toList());
    }
}
