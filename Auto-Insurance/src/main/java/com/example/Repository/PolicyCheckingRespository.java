package com.example.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Model.PolicyChecking;
import com.example.dto.PolicyCheckingDTO;

public interface PolicyCheckingRespository extends JpaRepository<PolicyChecking, Long> {

	PolicyChecking findByBikeId(Long bikeId);

	PolicyCheckingDTO deleteByBikeId(Long bikeId);
}



