package com.example.demo.Services;

import com.example.demo.Models.Match;
import com.example.demo.Models.Play;
import com.example.demo.dtos.Match.MatchDTO;
import com.example.demo.dtos.play.PlayRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    List<Match> getMatchByPlayer(Long player_id);
    Match createMatch(MatchDTO matchDTO);
    Match getMatchById(Long id);
    Play play(Long id, PlayRequest playRequest);
}
