package com.abhijeet.offsideAi.auth.repositories;

import com.abhijeet.offsideAi.auth.domain.entities.RefreshToken;
import com.abhijeet.offsideAi.user.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);
    int deleteByUser(User user);
    Optional<RefreshToken> findByUser(User user);
}
