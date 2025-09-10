package com.abhijeet.offsideAi.player.domain.entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "player_season_summary")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerSeasonSummary {

    /*
    id (PK)

player_id (FK → Players)

season_year

matches_played

goals

assists

minutes_played

yellow_cards

red_cards
     */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(name = "season_year", nullable = false)
    private Integer seasonYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "matches_played", nullable = false)
    private Integer matchesPlayed;

    @Column(name = "goals", nullable = false)
    private Integer goals;

    @Column(name = "assists", nullable = false)
    private Integer assists;

    @Column(name = "red_cards", nullable = false)
    private Integer redCards;

    @Column(name = "minutes_played", nullable = false)
    private Integer minutesPlayed;

    @Column(name = "yellow_cards", nullable = false)
    private Integer yellowCards;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
