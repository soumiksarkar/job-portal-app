package com.homeassignment.jobportalapp.service;

import com.homeassignment.jobportalapp.entity.Freelancer;
import com.homeassignment.jobportalapp.model.request.FreelancerCreateRequest;
import com.homeassignment.jobportalapp.model.request.LoginRequest;
import com.homeassignment.jobportalapp.model.response.FreelancerResponse;
import com.homeassignment.jobportalapp.repository.FreelancerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FreelancerService {

    private FreelancerRepository freelancerRepository;

    FreelancerService(FreelancerRepository freelancerRepository){
        this.freelancerRepository = freelancerRepository;
    }

    public List<FreelancerResponse> getFreelancers(){
        return freelancerRepository.findAll()
                .stream()
                .map(o -> FreelancerResponse.fromEntity(o))
                .collect(Collectors.toList());
    }

    public FreelancerResponse loadFreelancer(Long id){
        Optional<Freelancer> optional = freelancerRepository.findById(id);
        return FreelancerResponse.fromEntity(optional.get());
    }

    public FreelancerResponse createFreelancer(FreelancerCreateRequest request) {
        final Freelancer freelancer = request.toEntity();
        final Freelancer newFreelancer = freelancerRepository.save(freelancer);
        return FreelancerResponse.fromEntity(newFreelancer);
    }

    public FreelancerResponse authenticate(String username, String password){
        Optional<Freelancer> result = freelancerRepository.findByEmailAndPassword(username, password);
        if(result.isPresent()){
            return FreelancerResponse.fromEntity(result.get());
        }
        return null;
    }
}
