package com.sfl.mission_service.client;


import com.sfl.mission_service.dto.ResourceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Component
@RequiredArgsConstructor
public class ResourceClient {
    private final RestTemplate restTemplate;

    @Value("${resource.service.url}")
    private String resourceUrl; // e.g. http://localhost:8083/resource/

    public ResourceDTO getResourceById(Long resourceId) {
        return restTemplate.getForObject(
                resourceUrl+"/" + resourceId, // GET /resource/{id}
                ResourceDTO.class
        );
    }

    public void releaseResource(Long resourceId) {
        restTemplate.delete(resourceUrl +"/"+ resourceId); // DELETE /resource/{id}
    }

}