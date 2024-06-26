package com.example.demo.Services;

import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Player;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {
    Player getPlayerById(Long id);
    Player savePlayer(Player player);
}
