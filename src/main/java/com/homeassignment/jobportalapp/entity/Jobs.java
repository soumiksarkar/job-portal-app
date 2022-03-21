package com.homeassignment.jobportalapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Jobs extends BaseEntity{
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "req_exp")
    private String reqExp;
    private String skills;
    @Column(name = "job_desc")
    private String jobDesc;
    private Integer salary;
    @Column(name = "emplyr_id")
    private Long emplyrId;
}
