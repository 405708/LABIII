package com.example.demo.Services;

import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Match;
import com.example.demo.Models.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {
    Player getPlayerById(Long id);
    Player savePlayer(Player player);
    Player getPlayerByUserNameAndPassword(String userName, String password);
    Player getPlayerByEmailAndPassword(String email, String password);
    Player getPlayerByEmailOrUsernameAndPassword(String identity, String password);
}
