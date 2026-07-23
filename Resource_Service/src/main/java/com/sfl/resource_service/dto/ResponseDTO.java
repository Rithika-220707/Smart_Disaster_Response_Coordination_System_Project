package com.sfl.resource_service.dto;

import lombok.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private Long id;
    private String name;
    private int quantity;
    private boolean available;

}
