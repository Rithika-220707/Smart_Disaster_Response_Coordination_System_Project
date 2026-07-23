package com.sfl.alert_service.controller;


import com.sfl.alert_service.dto.RequestDTO;
import com.sfl.alert_service.dto.ResponseDTO;
import com.sfl.alert_service.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")

public class AlertController {
    private final AlertService service;

    public AlertController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody RequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAlert(dto));
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAlertById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}
