package com.sfl.mission_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RescueTeamDTO {
    @JsonProperty("id")
    public Long TeamId;
    private String teamName;
    private String location;
    private String contactNumber;
    private String specialization; // Medical, Fire, Flood
    private int teamSize;
    private boolean available;



}
