package com.sfl.resource_service.mapper;


import com.sfl.resource_service.dto.RequestDTO;
import com.sfl.resource_service.dto.ResponseDTO;
import com.sfl.resource_service.entity.Inventory;

public class ResourceMapper {

    public static Inventory toEntity(RequestDTO request) {
        Inventory inventory = new Inventory();
        inventory.setName(request.getName());
        inventory.setQuantity(request.getQuantity());
        inventory.setAvailable(request.isAvailable());
        return inventory;
    }

    public static ResponseDTO toResponse(Inventory inventory) {
        ResponseDTO response = new ResponseDTO();
        response.setId(inventory.getId());
        response.setName(inventory.getName());
        response.setQuantity(inventory.getQuantity());
        response.setAvailable(inventory.isAvailable());
        return response;
    }
}
