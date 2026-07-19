package com.sfl.incident_service.controller;

import com.sfl.incident_service.dto.IncidentRequest;
import com.sfl.incident_service.entity.Incident;
import com.sfl.incident_service.entity.IncidentStatus;
import com.sfl.incident_service.service.Incidentservice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final Incidentservice incidentService;

    @PostMapping
    public ResponseEntity<Incident> createIncident(
            @Valid @RequestBody IncidentRequest request) {

        Incident savedIncident = incidentService.createIncident(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedIncident);
    }

    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidents() {
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(incidentService.getIncidentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(
            @PathVariable Long id,
            @Valid @RequestBody IncidentRequest request) {

        return ResponseEntity.ok(
                incidentService.updateIncident(id, request)
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Incident> updateStatus(
            @PathVariable Long id,
            @RequestParam IncidentStatus status) {

        return ResponseEntity.ok(
                incidentService.updateIncidentStatus(id, status)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(
            @PathVariable Long id) {

        incidentService.deleteIncident(id);

        return ResponseEntity.noContent().build();
    }
}