package com.abhijeet.offsideAi.match.repositories;

import com.abhijeet.offsideAi.match.domain.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatchRepository extends JpaRepository<Match, UUID> {
}
