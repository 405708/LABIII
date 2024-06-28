package com.example.demo.Services.Implementations;

import com.example.demo.Entities.GameEntity;
import com.example.demo.Models.Game;
import com.example.demo.Repositories.GameJpaRepository;
import com.example.demo.Services.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameJpaRepository gameJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Game getGame(Long id) {
        GameEntity gameEntity = gameJpaRepository.getReferenceById(id);

        return modelMapper.map(gameEntity, Game.class);
    }
}
