package com.sfl.mission_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missionId;

    private Long incidentId;

    private Long teamId;

    private Long resourceId;

    private String severity;

    private String location;

    private String missionStatus;

    private LocalDateTime createdTime;

    private LocalDateTime assignedTime;

    private LocalDateTime completedTime;

    private String remarks;

}