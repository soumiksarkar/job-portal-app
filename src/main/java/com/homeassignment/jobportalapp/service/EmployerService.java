package com.homeassignment.jobportalapp.service;

import com.homeassignment.jobportalapp.entity.Employer;
import com.homeassignment.jobportalapp.entity.Freelancer;
import com.homeassignment.jobportalapp.model.request.EmployerCreateRequest;
import com.homeassignment.jobportalapp.model.response.EmployerResponse;
import com.homeassignment.jobportalapp.model.response.FreelancerResponse;
import com.homeassignment.jobportalapp.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployerService {

    private EmployerRepository employerRepository;

    EmployerService(EmployerRepository employerRepository){
        this.employerRepository = employerRepository;
    }

    public List<EmployerResponse> getEmployers(){
        return employerRepository.findAll()
                .stream()
                .map(EmployerResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public EmployerResponse loadEmployer(Long id){
        Optional<Employer> optional = employerRepository.findById(id);
        return EmployerResponse.fromEntity(optional.get());
    }

    public EmployerResponse createEmployer(EmployerCreateRequest request) {
        final Employer employer = request.toEntity();
        final Employer newEmployer = employerRepository.save(employer);
        return EmployerResponse.fromEntity(newEmployer);
    }

    public EmployerResponse authenticate(String username, String password){
        Optional<Employer> result = employerRepository.findByEmailAndPassword(username, password);
        if(result.isPresent()){
            return EmployerResponse.fromEntity(result.get());
        }
        return null;
    }
}
