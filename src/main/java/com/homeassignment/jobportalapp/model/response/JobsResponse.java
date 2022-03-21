package com.homeassignment.jobportalapp.model.response;

import com.homeassignment.jobportalapp.entity.Jobs;
import com.homeassignment.jobportalapp.model.JobsModel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@Builder
public class JobsResponse {
    private Long id;
    private String jobTitle;
    private String reqExp;
    private String skills;
    private String jobDesc;
    private Integer salary;
    private Long emplyrId;
    private String email;
    private String org;
    private Instant createdOn;

    public static JobsResponse fromEntity(Jobs entity){
        return JobsResponse.builder().
                id(entity.getId()).
                jobTitle(entity.getJobTitle()).
                reqExp(entity.getReqExp()).
                skills(entity.getSkills()).
                jobDesc(entity.getJobDesc()).
                salary(entity.getSalary()).
                emplyrId(entity.getEmplyrId()).build();
    }

    public static JobsResponse fromModel(JobsModel model) {
        return JobsResponse.builder().
                id(model.getId()).
                jobTitle(model.getJobTitle()).
                reqExp(model.getReqExp()).
                skills(model.getSkills()).
                jobDesc(model.getJobDesc()).
                salary(model.getSalary()).
                emplyrId(model.getEmplyrId())
                .email(model.getEmail())
                .org(model.getOrg())
                .createdOn(model.getCreatedOn()).build();
    }
}
