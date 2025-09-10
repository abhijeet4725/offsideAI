package com.abhijeet.offsideAi.player.domain.entities;

import com.abhijeet.offsideAi.match.domain.entities.MatchPlayerStats;
import com.abhijeet.offsideAi.team.domain.entities.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "player")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "photo_url", nullable = false)
    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id",nullable = false)
    private Team team;

    @OneToMany(mappedBy = "player", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<MatchPlayerStats> matchPlayerStats;

    @OneToMany(mappedBy = "player", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<PlayerSeasonSummary> playerSeasonSummaries;


    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
