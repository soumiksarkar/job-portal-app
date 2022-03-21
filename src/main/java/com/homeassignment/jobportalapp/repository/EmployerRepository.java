package com.homeassignment.jobportalapp.repository;

import com.homeassignment.jobportalapp.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Optional<Employer> findByEmailAndPassword(String email, String password);
}
