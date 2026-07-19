package com.sfl.incident_service.repository;

import com.sfl.incident_service.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepo extends JpaRepository<Incident,Long> {
}
