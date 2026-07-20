package com.sfl.rescue_team_service.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamRequestDTO {

        @NotBlank(message = "Team name is required")
        @Size(max = 100, message = "Team name must be less than 100 characters")
        private String teamName;

        @NotBlank(message = "Location is required")
        private String location;

        @NotBlank(message = "Contact number is required")
        @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits")
        private String contactNumber;

        @NotBlank(message = "Specialization is required")
        private String specialization;

        @NotNull(message = "Team size is required")
        @Min(value = 1, message = "Team size must be at least 1")
        private Integer teamSize;

        @NotNull(message = "Availability status is required")
        private Boolean available;

    }


