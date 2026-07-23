package com.sfl.resource_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class RequestDTO {

    @NotBlank(message = "Resource name is required")
    private String name;

    @Min(value = 1, message = "Quantity must be positive")
    private int quantity;

    private boolean available;
}
