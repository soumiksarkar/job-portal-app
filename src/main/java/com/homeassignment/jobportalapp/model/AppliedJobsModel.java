package com.homeassignment.jobportalapp.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppliedJobsModel {
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
}
