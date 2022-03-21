package com.homeassignment.jobportalapp.model.response;

import com.homeassignment.jobportalapp.entity.Freelancer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class FreelancerResponse {
    private Long id;
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

    public static FreelancerResponse fromEntity(Freelancer entity){
        return FreelancerResponse.builder().
                id(entity.getId()).
                name(entity.getName()).
                email(entity.getEmail()).
                cntctNum(entity.getCntctNum()).
                city(entity.getCity()).
                jobTitle(entity.getJobTitle()).
                jobBio(entity.getJobBio()).
                org(entity.getOrg()).
                desgntn(entity.getDesgntn()).
                wrkExpInYrs(entity.getWrkExpInYrs()).
                skills(entity.getSkills()).
                edu(entity.getEdu()).
                gitUname(entity.getGitUname()).
                salary(entity.getSalary()).build();
    }
}
