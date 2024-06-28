package com.example.demo.Services;

import com.example.demo.Models.rps.MatchRps;
import com.example.demo.Models.rps.PlayRps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayStrategyFactory {

    @Autowired
    private PlayMatch<PlayRps, MatchRps> playMatchRps;

    public PlayMatch getPlayStrategy(String code) {
        switch (code)
        {
            case "RPS":
                return playMatchRps;
            default:
                return playMatchRps;
        }
    }
}
