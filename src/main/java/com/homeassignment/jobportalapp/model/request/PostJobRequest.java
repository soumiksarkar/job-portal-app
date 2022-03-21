package com.homeassignment.jobportalapp.model.request;

import com.homeassignment.jobportalapp.entity.Jobs;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PostJobRequest {
    private String jobTitle;
    private String reqExp;
    private String skills;
    private String jobDesc;
    private Integer salary;
    private Long emplyrId;

    public Jobs toEntity(){
        return new Jobs(
                this.getJobTitle(),
                this.getReqExp(),
                this.getSkills(),
                this.getJobDesc(),
                this.getSalary(),
                this.getEmplyrId()
        );
    }
}
