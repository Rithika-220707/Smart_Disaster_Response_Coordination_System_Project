package com.sfl.alert_service.mapper;

import com.sfl.alert_service.dto.RequestDTO;
import com.sfl.alert_service.dto.ResponseDTO;
import com.sfl.alert_service.entity.Alert;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;

@Component
public class Alertmapper {

    public Alert toEntity(RequestDTO dto) {
        Alert alert = new Alert();
        BeanUtils.copyProperties(dto, alert);
        return alert;
    }

    public ResponseDTO toResponseDTO(Alert alert) {
        ResponseDTO dto = new ResponseDTO();
        BeanUtils.copyProperties(alert, dto);
        return dto;
    }
}
