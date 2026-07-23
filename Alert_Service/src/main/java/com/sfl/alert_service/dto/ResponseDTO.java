package com.sfl.alert_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseDTO {
    private Long id;
    private String message;
    private String location;
    private String severity;
    private LocalDateTime createdAt;
}
