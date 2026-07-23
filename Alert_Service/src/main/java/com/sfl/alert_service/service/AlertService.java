package com.sfl.alert_service.service;


import com.sfl.alert_service.dto.RequestDTO;
import com.sfl.alert_service.dto.ResponseDTO;
import com.sfl.alert_service.entity.Alert;
import com.sfl.alert_service.exception.AlertNotfoundException;
import com.sfl.alert_service.mapper.Alertmapper;
import com.sfl.alert_service.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertService {
    private final AlertRepository repo;
    private final Alertmapper mapper;

    public AlertService(AlertRepository repo, Alertmapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ResponseDTO createAlert(RequestDTO dto) {
        Alert saved = repo.save(mapper.toEntity(dto));
        return mapper.toResponseDTO(saved);
    }

    public List<ResponseDTO> getAllAlerts() {
        return repo.findAll().stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ResponseDTO getAlertById(Long id) {
        Alert alert = repo.findById(id)
                .orElseThrow(() -> new AlertNotfoundException("Alert not found with id " + id));
        return mapper.toResponseDTO(alert);
    }

    public void deleteAlert(Long id) {
        if (!repo.existsById(id)) {
            throw new AlertNotfoundException("Alert not found with id " + id);
        }
        repo.deleteById(id);
    }
}
