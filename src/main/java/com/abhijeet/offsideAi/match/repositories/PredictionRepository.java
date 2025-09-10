package com.abhijeet.offsideAi.match.repositories;

import com.abhijeet.offsideAi.match.domain.entities.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PredictionRepository extends JpaRepository<Prediction, UUID> {
}
