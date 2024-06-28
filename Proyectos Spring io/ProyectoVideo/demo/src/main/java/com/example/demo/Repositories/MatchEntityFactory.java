package com.example.demo.Repositories;

import com.example.demo.Entities.MatchEntity;
import com.example.demo.Entities.MatchRpsEntity;
import com.example.demo.Models.Match;
import com.example.demo.Models.rps.MatchRps;

public class MatchEntityFactory {

    public static Class<? extends MatchEntity> getTypeOfMatch(Match match)
    {
        switch (match.getGame().getCode())
        {
            case "RPS":
                return MatchRpsEntity.class;
            default:
                return MatchRpsEntity.class;
        }
    }
}
