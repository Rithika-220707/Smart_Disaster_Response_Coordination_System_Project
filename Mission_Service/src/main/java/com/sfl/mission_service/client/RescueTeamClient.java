package com.sfl.mission_service.client;


import com.sfl.mission_service.dto.RescueTeamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
@RequiredArgsConstructor
public class RescueTeamClient {
    private final RestTemplate restTemplate;

    @Value("${rescueteam.service.url}")
    private String teamUrl; // e.g. http://localhost:8082/rescueteam/

    public RescueTeamDTO getTeamById(Long teamId) {
        return restTemplate.getForObject(
                teamUrl+"/" + teamId, // GET /rescueteam/{id}
                RescueTeamDTO.class
        );
    }

    public void releaseTeam(Long teamId) {
        restTemplate.delete(teamUrl+"/" + teamId); // DELETE /rescueteam/{id}
    }
}
