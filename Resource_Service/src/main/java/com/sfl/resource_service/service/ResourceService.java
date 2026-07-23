package com.sfl.resource_service.service;

import com.sfl.resource_service.dto.RequestDTO;
import com.sfl.resource_service.dto.ResponseDTO;
import com.sfl.resource_service.entity.Inventory;
import com.sfl.resource_service.exception.ResourceNotFoundException;
import com.sfl.resource_service.mapper.ResourceMapper;
import com.sfl.resource_service.repository.ResourcesRepository;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ResourceService {

    private final ResourcesRepository inventoryRepository;

    public ResourceService(ResourcesRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public ResponseDTO createResource(RequestDTO request) {
        Inventory inventory = ResourceMapper.toEntity(request);
        Inventory saved = inventoryRepository.save(inventory);
        return ResourceMapper.toResponse(saved);
    }

    public List<ResponseDTO> getAllResources() {
        return inventoryRepository.findAll()
                .stream()
                .map(ResourceMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ResponseDTO getResourceById(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException("Resource not found with id: " + id);
                });
        return ResourceMapper.toResponse(inventory);
    }

    public ResponseDTO updateResource(Long id, RequestDTO request) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        inventory.setName(request.getName());
        inventory.setQuantity(request.getQuantity());
        inventory.setAvailable(request.isAvailable());
        Inventory updated = inventoryRepository.save(inventory);
        return ResourceMapper.toResponse(updated);
    }

    public void deleteResource(Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        inventoryRepository.delete(inventory);
    }
}
