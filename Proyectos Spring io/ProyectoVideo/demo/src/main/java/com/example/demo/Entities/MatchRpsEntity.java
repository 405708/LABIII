package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "matches_rps")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRpsEntity extends MatchEntity {

    private Long id; //viene de matchEntity

    private Integer numberOfPlays;

    private Integer remainderPlays;

    private Integer player1Score;

    private Integer player2Score;

    @OneToMany(mappedBy = "matchRps")
    private List<PlayRpsEntity> plays;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;
}
