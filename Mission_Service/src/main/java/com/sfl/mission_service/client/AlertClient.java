package com.sfl.mission_service.client;

import com.sfl.mission_service.dto.AlertDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AlertClient {


    private final RestTemplate restTemplate;


    @Value("${alert.service.url}")
    private String alertUrl;



    public void sendAlert(AlertDTO dto){


        restTemplate.postForEntity(
                alertUrl,
                dto,
                Void.class
        );

    }

}