package com.sfl.alert_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerts")
@Getter
@Setter
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String location;
    private String severity; // LOW, MEDIUM, HIGH
    private LocalDateTime createdAt = LocalDateTime.now();


}
