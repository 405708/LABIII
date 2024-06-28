package com.example.demo.Services;

import com.example.demo.Models.Match;
import com.example.demo.Models.Play;


public interface PlayMatch< P extends Play, M extends Match> {
    P play(P play, M match);
}
