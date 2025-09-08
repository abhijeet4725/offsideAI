package com.abhijeet.offsideAi.prompt.domain.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, UUID> {

}

