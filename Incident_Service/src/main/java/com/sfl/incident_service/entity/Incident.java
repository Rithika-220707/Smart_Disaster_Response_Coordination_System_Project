package com.sfl.incident_service.entity;
import jakarta.persistence.*;

import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Reported_Incidents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reporterName;
    private String mobile;
    private String location;
    private String disasterType;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private IncidentStatus status;
    private String description;
    private LocalDateTime reportedAt;
}

