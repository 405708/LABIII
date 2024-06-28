package com.example.demo.Services.Implementations;

import com.example.demo.Entities.MatchEntity;
import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.*;
import com.example.demo.Models.rps.MatchRps;
import com.example.demo.Repositories.MatchEntityFactory;
import com.example.demo.Repositories.MatchJpaRepository;
import com.example.demo.Services.*;
import com.example.demo.dtos.Match.MatchDTO;
import com.example.demo.dtos.play.PlayRequest;
import com.example.demo.dtos.play.PlayRpsDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchJpaRepository matchJpaRepository;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayStrategyFactory playStrategyFactory;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Match> getMatchByPlayer(Long playerId) {

        List<Match> matches = new ArrayList<>();
        Optional<List<MatchEntity>> listOptional =  matchJpaRepository.getAllByPlayer1Id(playerId);
        if(listOptional.isPresent())
        {
            listOptional.get().forEach(
                    me -> {matches.add(modelMapper.map(me, MatchFactory.getTypeOfMatch(me.getGame().getCode())));}
            );
        }
        return matches;
    }

    @Override
    public Match createMatch(MatchDTO matchDTO) {
        Player player = playerService.getPlayerById(matchDTO.getPlayerId());
        Game game = gameService.getGame(matchDTO.getGameId());

        Match match = MatchFactory.createMatch(player,game);
        MatchEntity matchEntity = matchJpaRepository.save(modelMapper.map(match, MatchEntityFactory.getTypeOfMatch(match)));
        return modelMapper.map(matchEntity, Match.class);
    }

    @Override
    public Match getMatchById(Long id) {
        MatchEntity me = (MatchEntity) Hibernate.unproxy(matchJpaRepository.getReferenceById(id));
        if(me != null)
        {
            Match match = modelMapper.map(me, MatchFactory.getTypeOfMatch(me.getGame().getCode()));
            return match;
        }
        else throw new EntityNotFoundException();
    }

    @Transactional
    @Override
    public Play play(Long id, PlayRequest playRequest) {
        Match match = this.getMatchById(id);
        if(match == null)
        {
            throw new EntityNotFoundException();
        }
        if(match.getStatus() != MatchStatus.STARTED)
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("The Match is %s" + match.getStatus()));
        }
        Play play = PlayFactory.getPlayInstance(playRequest,match.getGame().getCode());
        PlayMatch playMatch = playStrategyFactory.getPlayStrategy(match.getGame().getCode());
        return playMatch.play(play, match);
    }
}