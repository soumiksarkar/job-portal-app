package com.homeassignment.jobportalapp.model.response;

import com.homeassignment.jobportalapp.entity.Employer;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class EmployerResponse {
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
    private String edu;

    public static EmployerResponse fromEntity(Employer entity){
        return EmployerResponse.builder().
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
                edu(entity.getEdu()).build();
    }
}
