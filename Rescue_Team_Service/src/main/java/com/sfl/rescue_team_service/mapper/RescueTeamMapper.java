package com.sfl.rescue_team_service.mapper;

import com.sfl.rescue_team_service.dto.TeamRequestDTO;
import com.sfl.rescue_team_service.dto.TeamResponseDTO;
import com.sfl.rescue_team_service.entity.RescueTeam;

public class RescueTeamMapper {

    // Convert Request DTO → Entity
    public static RescueTeam toEntity(TeamRequestDTO dto) {
        RescueTeam team = new RescueTeam();
        team.setTeamName(dto.getTeamName());
        team.setLocation(dto.getLocation());
        team.setContactNumber(dto.getContactNumber());
        team.setSpecialization(dto.getSpecialization());
        team.setTeamSize(dto.getTeamSize());
        team.setAvailable(dto.getAvailable());
        return team;
    }

    // Convert Entity → Response DTO
    public static TeamResponseDTO toResponseDto(RescueTeam team) {
        return new TeamResponseDTO(
                team.getId(),
                team.getTeamName(),
                team.getLocation(),
                team.getContactNumber(),
                team.getSpecialization(),
                team.getTeamSize(),
                team.isAvailable()
        );
    }
}
