package com.sfl.rescue_team_service.exception;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {

    private int status;               // HTTP status code (e.g., 400, 404, 500)
    private String error;             // Short error type (e.g., "Bad Request")
    private String message;
    private LocalDateTime timestamp;  // When the error occurred
    // Detailed error message
    private String path;              // The endpoint path where the error happened
}