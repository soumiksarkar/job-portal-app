package com.homeassignment.jobportalapp.repository;

import com.homeassignment.jobportalapp.entity.Jobs;
import com.homeassignment.jobportalapp.model.JobsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {
    @Query("select " +
            "new com.homeassignment.jobportalapp.model.JobsModel( " +
            "j.id, j.jobTitle, j.reqExp, j.skills, j.jobDesc, j.salary, j.emplyrId, e.email, e.org, j.createdOn) " +
            "from Jobs j inner join Employer e on j.emplyrId = e.id")
    List<JobsModel> findAllJobs();
}
