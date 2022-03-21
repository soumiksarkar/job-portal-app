package com.homeassignment.jobportalapp.repository;

import com.homeassignment.jobportalapp.entity.JobApplctns;
import com.homeassignment.jobportalapp.model.AppliedJobsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplctnsRepository extends JpaRepository<JobApplctns, Long> {
    JobApplctns findByApplcntIdAndJobId(Long applcntId, Long jobId);

    @Query("select " +
            " new com.homeassignment.jobportalapp.model.AppliedJobsModel( " +
            " j.id, j.jobTitle, j.reqExp, j.skills, j.jobDesc, j.salary, j.emplyrId, e.email, e.org, j.createdOn, a.createdOn) " +
            " from JobApplctns a " +
            " inner join Jobs j on a.jobId = j.id " +
            " inner join Employer e on a.emplyrId = e.id " +
            " where a.applcntId = :applcntId ")
    List<AppliedJobsModel> findAllAppliedJobsByApplicantId(@Param("applcntId") Long applcntId);
}
