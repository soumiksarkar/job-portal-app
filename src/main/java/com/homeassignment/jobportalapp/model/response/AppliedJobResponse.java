package com.homeassignment.jobportalapp.model.response;

import com.homeassignment.jobportalapp.model.AppliedJobsModel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@Builder
public class AppliedJobResponse {

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
    private Instant appliedOn;

    public static AppliedJobResponse fromModel(AppliedJobsModel model){
        return AppliedJobResponse.builder().
                id(model.getId()).
                jobTitle(model.getJobTitle()).
                reqExp(model.getReqExp()).
                skills(model.getSkills()).
                jobDesc(model.getJobDesc()).
                salary(model.getSalary()).
                emplyrId(model.getEmplyrId())
                .email(model.getEmail())
                .org(model.getOrg())
                .createdOn(model.getCreatedOn())
                .appliedOn(model.getAppliedOn()).build();
    }
}
