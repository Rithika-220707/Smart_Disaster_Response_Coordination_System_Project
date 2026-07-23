package com.sfl.mission_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDTO {
    @JsonProperty("id")
    public Long ResourceId;
    private String name;
    private int quantity;
    private boolean available;
}
