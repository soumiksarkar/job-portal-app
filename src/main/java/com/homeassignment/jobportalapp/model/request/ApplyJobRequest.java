package com.homeassignment.jobportalapp.model.request;


import com.homeassignment.jobportalapp.entity.JobApplctns;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ApplyJobRequest {
    private Long applcntId;
    private Long jobId;
    private Long emplyrId;

    public JobApplctns toEntity(){
        return new JobApplctns(
                this.applcntId,
                this.jobId,
                this.emplyrId
        );
    }
}
