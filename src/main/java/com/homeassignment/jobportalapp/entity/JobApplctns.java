package com.homeassignment.jobportalapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "job_applctns")
public class JobApplctns extends BaseEntity {
    @Column(name = "applcnt_id")
    private Long applcntId;
    @Column(name = "job_id")
    private Long jobId;
    @Column(name = "emplyr_id")
    private Long emplyrId;
}
