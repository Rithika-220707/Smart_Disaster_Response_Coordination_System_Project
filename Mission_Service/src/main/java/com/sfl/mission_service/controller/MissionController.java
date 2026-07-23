package com.sfl.mission_service.controller;

import com.sfl.mission_service.dto.MissionRequestDTO;
import com.sfl.mission_service.dto.MissionResponseDTO;
import com.sfl.mission_service.service.MissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping
    public MissionResponseDTO createMission(@RequestBody MissionRequestDTO requestDTO) {
        return missionService.createMission(requestDTO);
    }

    @GetMapping("/{id}")
    public MissionResponseDTO getMission(@PathVariable Long id) {
        return missionService.getMission(id);
    }

    @GetMapping
    public List<MissionResponseDTO> getAllMissions() {
        return missionService.getAllMissions();
    }

    @PutMapping("/{id}/complete")
    public void completeMission(@PathVariable Long id) {
        missionService.completeMission(id);
    }

    @PostMapping("/{id}/alert")
    public void createMissionAlert(@PathVariable Long id) {
        missionService.createMissionAlert(id);
    }
}
