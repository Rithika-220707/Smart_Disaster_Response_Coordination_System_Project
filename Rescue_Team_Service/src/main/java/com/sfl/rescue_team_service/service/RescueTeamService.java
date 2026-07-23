package com.sfl.rescue_team_service.service;

import com.sfl.rescue_team_service.dto.TeamRequestDTO;
import com.sfl.rescue_team_service.dto.TeamResponseDTO;
import com.sfl.rescue_team_service.entity.RescueTeam;
import com.sfl.rescue_team_service.mapper.RescueTeamMapper;
import com.sfl.rescue_team_service.repository.RescueTeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RescueTeamService {

        private final RescueTeamRepo Repo;

        @Autowired
        public RescueTeamService(RescueTeamRepo Repo) {
            this.Repo = Repo;
        }


        public TeamResponseDTO createTeam(TeamRequestDTO dto) {
            RescueTeam team = RescueTeamMapper.toEntity(dto);
            RescueTeam savedTeam = Repo.save(team);
            return RescueTeamMapper.toResponseDto(savedTeam);
        }

        // Get a team by ID
        public TeamResponseDTO getTeamById(Long id) {
            RescueTeam team = Repo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rescue Team not found with id: " + id));
            return RescueTeamMapper.toResponseDto(team);
        }

        // Get all teams
        public List<TeamResponseDTO> getAllTeams() {
            return Repo.findAll()
                    .stream()
                    .map(RescueTeamMapper::toResponseDto)
                    .collect(Collectors.toList());
        }

        // Update a team
        public TeamResponseDTO updateTeam(Long id, TeamRequestDTO dto) {
            RescueTeam team = Repo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rescue Team not found with id: " + id));

            team.setTeamName(dto.getTeamName());
            team.setLocation(dto.getLocation());
            team.setContactNumber(dto.getContactNumber());
            team.setSpecialization(dto.getSpecialization());
            team.setTeamSize(dto.getTeamSize());
            team.setAvailable(dto.getAvailable());

            RescueTeam updatedTeam = Repo.save(team);
            return RescueTeamMapper.toResponseDto(updatedTeam);
        }

        // Delete a team
        public void deleteTeam(Long id) {
            if (!Repo.existsById(id)) {
                throw new RuntimeException("Rescue Team not found with id: " + id);
            }
            Repo.deleteById(id);
        }
    }


