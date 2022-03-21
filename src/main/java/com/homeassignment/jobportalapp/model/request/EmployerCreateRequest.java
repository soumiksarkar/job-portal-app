package com.homeassignment.jobportalapp.model.request;

import com.homeassignment.jobportalapp.entity.Employer;
import com.homeassignment.jobportalapp.entity.Freelancer;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class EmployerCreateRequest {
    private String name;
    private String email;
    private String cntctNum;
    private String city;
    private String jobTitle;
    private String jobBio;
    private String org;
    private String desgntn;
    private Integer wrkExpInYrs;
    private String edu;
    private String password;
    
    public Employer toEntity(){
        return new Employer(
                this.getName(),
                this.getEmail(),
                this.getCntctNum(),
                this.getCity(),
                this.getJobTitle(),
                this.getJobBio(),
                this.getOrg(),
                this.getDesgntn(),
                this.getWrkExpInYrs(),
                this.getEdu(),
                this.getPassword()
        );
    }
}
