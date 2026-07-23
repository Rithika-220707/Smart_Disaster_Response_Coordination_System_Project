package com.sfl.rescue_team_service.repository;

import com.sfl.rescue_team_service.entity.RescueTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RescueTeamRepo extends JpaRepository<RescueTeam,Long> {

}
