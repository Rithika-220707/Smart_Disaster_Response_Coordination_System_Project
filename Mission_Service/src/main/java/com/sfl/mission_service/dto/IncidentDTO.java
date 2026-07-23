package com.sfl.mission_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.mission_service.entity.Severity;
import com.sfl.mission_service.entity.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncidentDTO {
    private Long id;
    private String reporterName;
    private String mobile;
    private String location;
    private String disasterType;
    @Enumerated(EnumType.STRING)
    private Severity severity;
    @Enumerated(EnumType.STRING)
// LOW, MEDIUM, HIGH
    @JsonProperty("status")
    private Status Status;
    private String description;
    private LocalDateTime reportedAt;

}
