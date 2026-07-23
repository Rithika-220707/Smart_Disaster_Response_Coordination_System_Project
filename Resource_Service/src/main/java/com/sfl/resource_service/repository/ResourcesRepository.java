package com.sfl.resource_service.repository;

import com.sfl.resource_service.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesRepository extends JpaRepository<Inventory,Long> {
}
