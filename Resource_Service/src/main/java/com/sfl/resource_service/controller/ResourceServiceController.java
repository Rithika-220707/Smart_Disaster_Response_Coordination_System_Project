package com.sfl.resource_service.controller;

import com.sfl.resource_service.dto.RequestDTO;
import com.sfl.resource_service.dto.ResponseDTO;
import com.sfl.resource_service.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/resources")
@Slf4j
public class ResourceServiceController {

    private final ResourceService resourceService;

    public ResourceServiceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createResource(@Valid @RequestBody RequestDTO requestDTO) {
        return ResponseEntity.ok(resourceService.createResource(requestDTO));
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getResourceById(@PathVariable Long id) {
        return ResponseEntity.ok(resourceService.getResourceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateResource(@PathVariable Long id,
                                                      @Valid @RequestBody RequestDTO requestDTO) {
        return ResponseEntity.ok(resourceService.updateResource(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return ResponseEntity.noContent().build();
    }
}
