package com.homeassignment.jobportalapp.model.request;

import com.homeassignment.jobportalapp.entity.Freelancer;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class FreelancerCreateRequest {
    private String name;
    private String email;
    private String cntctNum;
    private String city;
    private String jobTitle;
    private String jobBio;
    private String org;
    private String desgntn;
    private Integer wrkExpInYrs;
    private String skills;
    private String edu;
    private String gitUname;
    private Integer salary;
    private String password;
    
    public Freelancer toEntity(){
        return new Freelancer(
                this.getName(),
                this.getEmail(),
                this.getCntctNum(),
                this.getCity(),
                this.getJobTitle(),
                this.getJobBio(),
                this.getOrg(),
                this.getDesgntn(),
                this.getWrkExpInYrs(),
                this.getSkills(),
                this.getEdu(),
                this.getGitUname(),
                this.getSalary(),
                this.getPassword()
        );
    }
}
