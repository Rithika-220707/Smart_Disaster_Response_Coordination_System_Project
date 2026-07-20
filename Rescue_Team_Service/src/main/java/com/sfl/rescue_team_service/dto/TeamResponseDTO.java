package com.sfl.rescue_team_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDTO {

    private Long id;
    private String teamName;
    private String location;
    private String contactNumber;
    private String specialization;
    private int teamSize;
    private boolean available;
}
