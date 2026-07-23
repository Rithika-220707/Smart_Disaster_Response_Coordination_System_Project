package com.sfl.alert_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RequestDTO {

    @NotBlank(message = "Message is required")
    private String message;

    @NotBlank(message = "Location is required")
    private String location;

    @Pattern(regexp = "LOW|MEDIUM|HIGH", message = "Severity must be LOW, MEDIUM, or HIGH")
    private String severity;


}
