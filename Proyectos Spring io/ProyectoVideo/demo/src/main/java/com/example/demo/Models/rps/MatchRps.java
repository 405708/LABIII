package com.example.demo.Models.rps;

import com.example.demo.Entities.PlayRpsEntity;
import com.example.demo.Models.Match;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchRps extends Match {
    private Integer numberOfPlays;
    private Integer remainderPlays;
    private Integer player1Score;
    private Integer player2Score;
    private List<PlayRps> plays;
    private PlayRpsEntity winner;
    private Long winnerId;
    private LocalDateTime updatedAt;
}
