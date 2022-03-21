package com.homeassignment.jobportalapp.repository;

import com.homeassignment.jobportalapp.entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
    Optional<Freelancer> findByEmailAndPassword(String email, String password);
}
