package com.sfl.mission_service.client;

import com.sfl.mission_service.dto.IncidentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Slf4j
@Component
@RequiredArgsConstructor
public class IncidentClient {

    private final RestTemplate restTemplate;

    @Value("${incident.service.url}")
    private String incidentUrl;

    public IncidentDTO getIncidentById(Long incidentId) {
        log.info("calling Incident service at {}",incidentUrl+incidentId);
        return restTemplate.getForObject(
                incidentUrl+"/"+ incidentId,
                IncidentDTO.class
        );
    }
}