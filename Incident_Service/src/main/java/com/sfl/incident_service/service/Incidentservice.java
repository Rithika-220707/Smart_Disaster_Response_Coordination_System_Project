package com.sfl.incident_service.service;

import com.sfl.incident_service.dto.IncidentRequest;
import com.sfl.incident_service.entity.Incident;
import com.sfl.incident_service.entity.IncidentStatus;
import com.sfl.incident_service.exception.IncidentNotFoundException;
import com.sfl.incident_service.repository.IncidentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Incidentservice {

    private final IncidentRepo incidentRepository;


    public Incident createIncident(IncidentRequest request) {
        Incident incident = Incident.builder()
                .reporterName(request.getReporterName())
                .mobile(request.getMobile())
                .location(request.getLocation())
                .disasterType(request.getDisasterType())
                .severity(request.getSeverity())
                .description(request.getDescription())
                .status(IncidentStatus.REPORTED)
                .reportedAt(LocalDateTime.now())
                .build();

        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident getIncidentById(Long id) {
        return incidentRepository.findById(id)
                .orElseThrow(() -> new IncidentNotFoundException(id));
    }

    public Incident updateIncident(Long id, IncidentRequest request) {
        Incident incident = getIncidentById(id);

        incident.setReporterName(request.getReporterName());
        incident.setMobile(request.getMobile());
        incident.setLocation(request.getLocation());
        incident.setDisasterType(request.getDisasterType());
        incident.setSeverity(request.getSeverity());
        incident.setDescription(request.getDescription());

        return incidentRepository.save(incident);
    }

    public Incident updateIncidentStatus(Long id, IncidentStatus status) {
        Incident incident = getIncidentById(id);

        incident.setStatus(status);

        return incidentRepository.save(incident);
    }

    public void deleteIncident(Long id) {
        Incident incident = getIncidentById(id);
        incidentRepository.delete(incident);
    }
}