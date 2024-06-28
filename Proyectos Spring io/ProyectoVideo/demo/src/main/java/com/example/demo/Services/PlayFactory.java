package com.example.demo.Services;

import com.example.demo.Models.Match;
import com.example.demo.Models.Play;
import com.example.demo.Models.rps.MatchRps;
import com.example.demo.Models.rps.PlayRps;
import com.example.demo.dtos.play.PlayRequest;
import com.example.demo.dtos.play.PlayRpsDTO;

public class PlayFactory {
    public static Play getPlayInstance(PlayRequest playRequest, String gameCode) {
        switch (gameCode){
            case "RPS":
                return getPlayRpsInstance(playRequest);
            default:
                return getPlayRpsInstance(playRequest);
        }
    }

    public static Play getPlayRpsInstance(PlayRequest playRequest) {
        PlayRpsDTO playRpsDTO = (PlayRpsDTO) playRequest;
        PlayRps playRps = new PlayRps();
        playRps.setShapeHandPlayer1(playRpsDTO.getShapeHandPlayer1());
        playRps.setShapeHandPlayer2(playRpsDTO.getShapeHandPlayer2());
        return playRps;
    }
}
