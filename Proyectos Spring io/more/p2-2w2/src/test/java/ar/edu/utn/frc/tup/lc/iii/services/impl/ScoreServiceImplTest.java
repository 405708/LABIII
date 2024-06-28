package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.models.GamePrediction;
import ar.edu.utn.frc.tup.lc.iii.models.GameResult;
import ar.edu.utn.frc.tup.lc.iii.services.GameService;
import ar.edu.utn.frc.tup.lc.iii.services.ScoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreServiceImplTest {

    @Autowired
    private ScoreService scoreService;
    @Autowired
    private GameService gameService;
    @Test
    void calculateScore() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // TODO(Completado) Testing
        Method calculateScore = scoreService.getClass().getDeclaredMethod("calculateScore", GamePrediction.class, GameResult.class);
        calculateScore.setAccessible(true);
        calculateScore.invoke(scoreService, gameService.getPrediction(200L, 1L), gameService.getGameResultByGameId(1L));
        scoreService.getScores().forEach(userScore -> {
            if (userScore.getUser().getId().equals(200L)) {
                assertEquals(1, userScore.getPoints());
            }
        }
        );
    }
}