package com.sfl.rescue_team_service.controller;

import com.sfl.rescue_team_service.dto.TeamRequestDTO;
import com.sfl.rescue_team_service.dto.TeamResponseDTO;
import com.sfl.rescue_team_service.service.RescueTeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rescueteam")
@RequiredArgsConstructor
public class RescueTeamController {
    private final RescueTeamService rescueservice;

    @PostMapping("/teams")
    public ResponseEntity<TeamResponseDTO> createTeam(
            @Valid @RequestBody TeamRequestDTO dto) {
        TeamResponseDTO savedinfo = rescueservice.createTeam(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedinfo);
    }
    // Get a team by ID
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable Long id) {
        TeamResponseDTO response = rescueservice.getTeamById(id);
        return ResponseEntity.ok(response);
    }

    // Get all teams
    @GetMapping
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        List<TeamResponseDTO> responseList = rescueservice.getAllTeams();
        return ResponseEntity.ok(responseList);
    }

    // Update a team
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> updateTeam(
            @PathVariable Long id,
            @Valid @RequestBody TeamRequestDTO dto) {
        TeamResponseDTO response = rescueservice.updateTeam(id, dto);
        return ResponseEntity.ok(response);
    }
    // Delete a team
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        rescueservice.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }

}
