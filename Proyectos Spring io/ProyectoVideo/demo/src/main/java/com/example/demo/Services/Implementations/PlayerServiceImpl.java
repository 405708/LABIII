package com.example.demo.Services.Implementations;

import com.example.demo.Controllers.PlayerController;
import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Match;
import com.example.demo.Models.Player;
import com.example.demo.Repositories.PlayerJpaRepository;
import com.example.demo.Services.MatchService;
import com.example.demo.Services.PlayerService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity = playerJpaRepository.getReferenceById(id);
        if(Objects.isNull(playerEntity.getUsername()))
        {
            throw new EntityNotFoundException();
        }
        Player player = modelMapper.map(playerEntity, Player.class);
        return player;
    }

    @Override
    public Player savePlayer(Player player) { //Mapeamos el player a entity, guardamos en db y volvemos a Player para devolverlo
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUsernameOrEmail(
                player.getUserName(), player.getEmail());
        if(playerEntityOptional.isEmpty())
        {
            PlayerEntity playerEntity = modelMapper.map(player, PlayerEntity.class);
            PlayerEntity playerEntitySaved = playerJpaRepository.save(playerEntity);
            return modelMapper.map(playerEntitySaved, Player.class);
        }
        else return null;
    }

    @Override
    public Player getPlayerByUserNameAndPassword(String userName, String password) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUsernameAndPassword(userName, password);
        if(playerEntityOptional.isPresent())
        {
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }
        else throw new EntityNotFoundException("Username o Password invalida");
    }

    @Override
    public Player getPlayerByEmailAndPassword(String email, String password) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByEmailAndPassword(email, password);
        if(playerEntityOptional.isPresent())
        {
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }
        else throw new EntityNotFoundException("Email o Password invalida");
    }

    @Override
    public Player getPlayerByEmailOrUsernameAndPassword(String identity, String password) {
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUsernameOrEmailAndPassword(identity, password);
        if(playerEntityOptional.isPresent())
        {
            return modelMapper.map(playerEntityOptional.get(), Player.class);
        }
        else throw new EntityNotFoundException("Email/Usuario o Password invalida");
    }

}
