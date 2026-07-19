package com.sfl.incident_service.dto;

import com.sfl.incident_service.entity.Severity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentRequest {

    @NotBlank(message = "Reporter name is required")
    private String reporterName;

    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Mobile number must contain exactly 10 digits"
    )
    private String mobile;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotBlank(message = "Disaster type is required")
    private String disasterType;

    @NotNull(message = "Severity is required")
    private Severity severity;

    private String description;
}