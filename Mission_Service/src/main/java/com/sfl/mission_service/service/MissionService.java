package com.sfl.mission_service.service;

import com.sfl.mission_service.client.AlertClient;
import com.sfl.mission_service.client.IncidentClient;
import com.sfl.mission_service.client.RescueTeamClient;
import com.sfl.mission_service.client.ResourceClient;
import com.sfl.mission_service.dto.*;
import com.sfl.mission_service.entity.Mission;
import com.sfl.mission_service.exception.MissionNotFoundException;
import com.sfl.mission_service.mapper.MissionMapper;
import com.sfl.mission_service.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;
    private final IncidentClient incidentClient;
    private final RescueTeamClient rescueTeamClient;
    private final ResourceClient resourceClient;
    private final AlertClient alertClient;

    public MissionService(MissionRepository missionRepository,
                          MissionMapper missionMapper,
                          IncidentClient incidentClient,
                          RescueTeamClient rescueTeamClient,
                          ResourceClient resourceClient,
                          AlertClient alertClient) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
        this.incidentClient = incidentClient;
        this.rescueTeamClient = rescueTeamClient;
        this.resourceClient = resourceClient;
        this.alertClient = alertClient;
    }

    public MissionResponseDTO createMission(MissionRequestDTO requestDTO) {
        Mission mission = new Mission();
        mission.setIncidentId(requestDTO.getIncidentId());
        mission.setCreatedTime(LocalDateTime.now());

        // Incident details
        IncidentDTO incident = incidentClient.getIncidentById(requestDTO.getIncidentId());
        mission.setLocation(incident.getLocation());
        mission.setSeverity(String.valueOf(incident.getSeverity()));
        mission.setMissionStatus(String.valueOf(incident.getStatus()));

        // Team (just fetch by id for now)
        RescueTeamDTO team = rescueTeamClient.getTeamById(incident.getId());
        mission.setTeamId(team.getTeamId());

        // Resource
        ResourceDTO resource = resourceClient.getResourceById(incident.getId());
        mission.setResourceId(resource.getResourceId());

        mission.setAssignedTime(LocalDateTime.now());

        Mission saved = missionRepository.save(mission);

        // Build alert payload
        AlertDTO alert = AlertDTO.builder()
                .missionId(saved.getMissionId())
                .incidentId(saved.getIncidentId())
                .status(saved.getMissionStatus())
                .severity(saved.getSeverity())
                .location(saved.getLocation())
                .message("Mission created")
                .timestamp(LocalDateTime.now().toString())
                .build();

        alertClient.sendAlert(alert);

        return missionMapper.toResponseDTO(saved);
    }

    public MissionResponseDTO getMission(Long id) {
        Mission mission = missionRepository.findById(id)
                .orElseThrow(() -> new MissionNotFoundException("Mission not found: " + id));
        return missionMapper.toResponseDTO(mission);
    }

    public List<MissionResponseDTO> getAllMissions() {
        return missionRepository.findAll()
                .stream()
                .map(missionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public void completeMission(Long id) {
        Mission mission = missionRepository.findById(id)
                .orElseThrow(() -> new MissionNotFoundException("Mission not found: " + id));

        mission.setMissionStatus("COMPLETED");
        mission.setCompletedTime(LocalDateTime.now());
        missionRepository.save(mission);

        rescueTeamClient.releaseTeam(mission.getTeamId());
        resourceClient.releaseResource(mission.getResourceId());
    }

    public void createMissionAlert(Long missionId) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionNotFoundException("Mission not found: " + missionId));

        AlertDTO alert = AlertDTO.builder()
                .missionId(mission.getMissionId())
                .incidentId(mission.getIncidentId())
                .status("ESCALATED")
                .severity(mission.getSeverity())
                .location(mission.getLocation())
                .message("Mission escalated after 30 minutes")
                .timestamp(LocalDateTime.now().toString())
                .build();

        alertClient.sendAlert(alert);
    }
}
