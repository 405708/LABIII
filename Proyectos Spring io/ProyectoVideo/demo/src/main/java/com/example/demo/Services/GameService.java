package com.example.demo.Services;

import com.example.demo.Models.Game;
import org.springframework.stereotype.Service;

@Service
public interface GameService {
    Game getGame(Long id);
}
