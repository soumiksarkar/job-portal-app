package com.homeassignment.jobportalapp.entity;

import com.homeassignment.jobportalapp.model.request.FreelancerCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Freelancer extends BaseEntity {
    private String name;
    private String email;
    @Column(name="cntct_num")
    private String cntctNum;
    private String city;
    @Column(name="job_title")
    private String jobTitle;
    @Column(name="job_bio")
    private String jobBio;
    private String org;
    private String desgntn;
    @Column(name="wrk_exp_in_yrs")
    private Integer wrkExpInYrs;
    private String skills;
    private String edu;
    private String gitUname;
    private Integer salary;
    private String password;
}
