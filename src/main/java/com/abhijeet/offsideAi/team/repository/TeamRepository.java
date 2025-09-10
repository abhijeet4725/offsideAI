package com.abhijeet.offsideAi.team.repository;

import com.abhijeet.offsideAi.team.domain.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    Optional<Team> findByName(String name);
    boolean existsByName(String name);
}

