package com.abhijeet.offsideAi.prompt.repository;

import com.abhijeet.offsideAi.prompt.domain.entities.Prompt;
import com.abhijeet.offsideAi.user.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PromptRepository extends JpaRepository<Prompt, UUID> {
    // Fetch last 10 prompts for a given user (oldest first)
    List<Prompt> findTop10ByUserOrderByCreatedAtAsc(User user);

    // (Optional) If you prefer latest first
    List<Prompt> findTop10ByUserOrderByCreatedAtDesc(User user);
}

