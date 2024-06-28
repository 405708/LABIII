package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.entities.GameEntity;
import ar.edu.utn.frc.tup.lc.iii.entities.TeamEntity;
import ar.edu.utn.frc.tup.lc.iii.models.FaseGame;
import ar.edu.utn.frc.tup.lc.iii.models.GamePrediction;
import ar.edu.utn.frc.tup.lc.iii.models.Result;
import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.repositories.GameRepository;
import ar.edu.utn.frc.tup.lc.iii.services.GameService;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class GameServiceImplTest {


    @Autowired
    private GameService gameService;

    @MockBean
    private GameRepository gameRepository;

    @MockBean
    private UserService userService;

    @Test
    void setGameResultByGameIdTest_noExists() {
        // TODO(Completado) Testing
        when(gameService.getGameResultByGameId(10L)).thenReturn(null);

        assertThrows(HttpClientErrorException.class, () -> gameService.setGameResultByGameId(10L, 1, 2));
    }

    @Test
    void predictTestCorrect() {
        // TODO(Completado) Testing
        GameEntity gameEntity = new GameEntity();
        gameEntity.setId(1L);
        gameEntity.setFaseGame(FaseGame.SEMI_FINALS);
        gameEntity.setLocal(new TeamEntity(1L, "Argentina"));
        gameEntity.setLocal(new TeamEntity(2L, "Venezuela"));
        gameEntity.setStadium("MetLifeStadium");
        gameEntity.setGameDate(LocalDateTime.now().plusDays(10));

        when(Hibernate.unproxy(gameRepository.getReferenceById(any()))).thenReturn(gameEntity);
        when(userService.getUserById(any())).thenReturn(new User(100L, "Martin", "test", "test@email.com", "Password12"));
        GamePrediction gamePrediction = gameService.predict(100L, 1L, 1, 2);

        assertEquals(1, gamePrediction.getLocalGoals());
        assertEquals(5, gamePrediction.getVisitorGoals());
        assertEquals(Result.VISITOR_WIN, gamePrediction.getResult());
    }
}