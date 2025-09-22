package com.example.eligibility.repository;

import com.example.eligibility.entity.EligibilityStatus;
import com.example.eligibility.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByPatientId(String patientId);

    Optional<Patient> findByMemberId(String memberId);

    List<Patient> findByEligibilityStatus(EligibilityStatus status);

    boolean existsByPatientId(String patientId);

    boolean existsByMemberId(String memberId);

    List<Patient> findByEligibilityStatusAndEffectiveDateBeforeAndTerminationDateAfter(
            EligibilityStatus status, java.time.LocalDate effectiveDate, java.time.LocalDate terminationDate);
}
