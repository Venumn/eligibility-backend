package com.example.eligibility.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "eligibility_requests")
public class EligibilityRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Request ID is required")
    @Column(name = "request_id", unique = true, nullable = false)
    private String requestId;

    @NotBlank(message = "Patient ID is required")
    @Column(name = "patient_id", nullable = false)
    private String patientId;

    @NotBlank(message = "Member ID is required")
    @Column(name = "member_id", nullable = false)
    private String memberId;

    @NotBlank(message = "Provider ID is required")
    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @Column(name = "response_date")
    private LocalDateTime responseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EligibilityStatus status;

    @Column(name = "response_message", length = 1000)
    private String responseMessage;

    @Column(name = "response_time_ms")
    private Long responseTimeMs;

    // Default constructor
    public EligibilityRequest() {}

    // Parameterized constructor
    public EligibilityRequest(String requestId, String patientId, String memberId,
                              String providerId, String serviceType) {
        this.requestId = requestId;
        this.patientId = patientId;
        this.memberId = memberId;
        this.providerId = providerId;
        this.serviceType = serviceType;
        this.requestDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getProviderId() { return providerId; }
    public void setProviderId(String providerId) { this.providerId = providerId; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }

    public LocalDateTime getResponseDate() { return responseDate; }
    public void setResponseDate(LocalDateTime responseDate) { this.responseDate = responseDate; }

    public EligibilityStatus getStatus() { return status; }
    public void setStatus(EligibilityStatus status) { this.status = status; }

    public String getResponseMessage() { return responseMessage; }
    public void setResponseMessage(String responseMessage) { this.responseMessage = responseMessage; }

    public Long getResponseTimeMs() { return responseTimeMs; }
    public void setResponseTimeMs(Long responseTimeMs) { this.responseTimeMs = responseTimeMs; }
}
