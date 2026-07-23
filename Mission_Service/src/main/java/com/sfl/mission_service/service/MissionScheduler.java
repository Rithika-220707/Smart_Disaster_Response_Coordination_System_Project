package com.sfl.mission_service.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MissionScheduler {

    private final MissionService missionService;

    public MissionScheduler(MissionService missionService) {
        this.missionService = missionService;
    }

    // Escalate unresolved missions after 30 minutes
    @Scheduled(fixedRate = 300000) // every 5 minutes
    public void escalateUnresolvedMissions() {
        missionService.getAllMissions().stream()
                .filter(m -> "ASSIGNED".equalsIgnoreCase(m.getMissionStatus()))
                .filter(m -> m.getAssignedTime().isBefore(LocalDateTime.now().minusMinutes(30)))
                .forEach(m -> {
                    System.out.println("Escalating mission: " + m.getMissionId());
                    // Call alert service for escalation
                    missionService.createMissionAlert(m.getMissionId());
                });
    }
}
