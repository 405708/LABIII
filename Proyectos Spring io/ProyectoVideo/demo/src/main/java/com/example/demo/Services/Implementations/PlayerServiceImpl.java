package com.example.demo.Services.Implementations;

import com.example.demo.Controllers.PlayerController;
import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Player;
import com.example.demo.Repositories.PlayerJpaRepository;
import com.example.demo.Services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity = playerJpaRepository.getReferenceById(id);
        Player player = modelMapper.map(playerEntity, Player.class);
        return player;
    }

    @Override
    public Player savePlayer(Player player) { //Mapeamos el player a entity, guardamos en db y volvemos a Player para devolverlo
        PlayerEntity playerEntity = modelMapper.map(player, PlayerEntity.class);
        PlayerEntity playerEntitySaved = playerJpaRepository.save(playerEntity);
        return modelMapper.map(playerEntitySaved, Player.class);
    }
}
