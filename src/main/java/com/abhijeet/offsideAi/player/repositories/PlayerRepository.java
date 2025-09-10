package com.abhijeet.offsideAi.player.repositories;

import com.abhijeet.offsideAi.player.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
