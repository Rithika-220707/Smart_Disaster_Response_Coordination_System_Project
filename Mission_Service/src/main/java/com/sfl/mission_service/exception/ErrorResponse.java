package com.sfl.mission_service.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {

        private int status;
        private String error;
        private Object message;
        private LocalDateTime timestamp;
        private String path;

    }


