package com.sfl.resource_service.exception;

import lombok.*;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse{

    private int status;
    private String error;
    private Object message;
    private LocalDateTime timestamp;
    private String path;

}
