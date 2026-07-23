package com.sfl.mission_service.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionResponseDTO {

    private Long missionId;

    private Long incidentId;

    private Long teamId;

    private Long resourceId;

    private String severity;

    private String location;

    private String missionStatus;

    private LocalDateTime assignedTime;
}