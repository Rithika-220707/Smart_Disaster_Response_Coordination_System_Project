package com.sfl.mission_service.mapper;

import com.sfl.mission_service.dto.MissionRequestDTO;
import com.sfl.mission_service.dto.MissionResponseDTO;
import com.sfl.mission_service.entity.Mission;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {
    public Mission toEntity(MissionRequestDTO dto) {
        Mission mission = new Mission();
        BeanUtils.copyProperties(dto, mission);
        return mission;
    }

    public MissionResponseDTO toResponseDTO(Mission mission) {
        MissionResponseDTO dto = new MissionResponseDTO();
        BeanUtils.copyProperties(mission, dto);
        return dto;
    }
}
