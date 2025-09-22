package com.example.eligibility.config;

import com.example.eligibility.entity.*;
import com.example.eligibility.repository.PatientRepository;
import com.example.eligibility.repository.EligibilityRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final EligibilityRequestRepository eligibilityRequestRepository;

    public DataLoader(PatientRepository patientRepository,
                      EligibilityRequestRepository eligibilityRequestRepository) {
        this.patientRepository = patientRepository;
        this.eligibilityRequestRepository = eligibilityRequestRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only load data if database is empty
        if (patientRepository.count() == 0) {
            loadTestData();
        }
    }

    private void loadTestData() {
        // Create patients
        Patient patient1 = new Patient(
                "P001", "M001", "John", "Doe",
                LocalDate.of(1985, 5, 15), Gender.MALE, EligibilityStatus.ACTIVE,
                LocalDate.of(2024, 1, 1), "PPO"
        );
        patient1.setTerminationDate(LocalDate.of(2024, 12, 31));
        patient1.setGroupNumber("GRP001");

        Patient patient2 = new Patient(
                "P002", "M002", "Jane", "Smith",
                LocalDate.of(1990, 8, 22), Gender.FEMALE, EligibilityStatus.ACTIVE,
                LocalDate.of(2024, 1, 1), "HMO"
        );
        patient2.setTerminationDate(LocalDate.of(2024, 12, 31));
        patient2.setGroupNumber("GRP001");

        Patient patient3 = new Patient(
                "P003", "M003", "Robert", "Johnson",
                LocalDate.of(1978, 3, 10), Gender.MALE, EligibilityStatus.TERMINATED,
                LocalDate.of(2024, 1, 1), "PPO"
        );
        patient3.setTerminationDate(LocalDate.of(2024, 6, 30));
        patient3.setGroupNumber("GRP002");

        patientRepository.saveAll(Arrays.asList(patient1, patient2, patient3));

        // Create eligibility requests
        EligibilityRequest request1 = new EligibilityRequest(
                "REQ001", "P001", "M001", "PROV001", "Office Visit"
        );
        request1.setStatus(EligibilityStatus.ACTIVE);
        request1.setResponseMessage("Patient is active and eligible for office visits");
        request1.setResponseTimeMs(150L);

        EligibilityRequest request2 = new EligibilityRequest(
                "REQ002", "P003", "M003", "PROV002", "Surgery"
        );
        request2.setStatus(EligibilityStatus.TERMINATED);
        request2.setResponseMessage("Patient coverage terminated on 2024-06-30");
        request2.setResponseTimeMs(120L);

        eligibilityRequestRepository.saveAll(Arrays.asList(request1, request2));

        System.out.println("Eligibility test data loaded successfully!");
        System.out.println("Patients: " + patientRepository.count());
        System.out.println("Eligibility Requests: " + eligibilityRequestRepository.count());
    }
}
