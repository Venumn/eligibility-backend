package com.example.eligibility.repository;

import com.example.eligibility.entity.EligibilityRequest;
import com.example.eligibility.entity.EligibilityStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EligibilityRequestRepository extends JpaRepository<EligibilityRequest, Long> {

    Optional<EligibilityRequest> findByRequestId(String requestId);

    List<EligibilityRequest> findByPatientId(String patientId);

    List<EligibilityRequest> findByProviderId(String providerId);

    List<EligibilityRequest> findByStatus(EligibilityStatus status);

    List<EligibilityRequest> findByRequestDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    long countByRequestDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    long countByStatusAndRequestDateBetween(EligibilityStatus status, LocalDateTime startDate, LocalDateTime endDate);
}
