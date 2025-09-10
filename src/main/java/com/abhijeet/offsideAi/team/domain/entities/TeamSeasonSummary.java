package com.abhijeet.offsideAi.team.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "team_season_summary")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamSeasonSummary {

    /*
    id (PK)

team_id (FK → Teams)

season_year

matches_played

wins

draws

losses

goals_scored

goals_conceded

points (usually 3 × wins + 1 × draws)
     */

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "season_year", nullable = false)
    private Integer seasonYear;

    @Column(name = "matches_played", nullable = false)
    private Integer matchesPlayed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;


    @Column(name = "wins", nullable = false)
    private Integer wins;

    @Column(name = "loses", nullable = false)
    private Integer loses;

    @Column(name = "draws", nullable = false)
    private Integer draws;

    @Column(name = "goals_scored", nullable = false)
    private Integer goalsScored;

    @Column(name = "goals_conceded", nullable = false)
    private Integer goalsConceded;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
