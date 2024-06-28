package ar.edu.utn.frc.tup.lc.iii.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResult {

    private Long id;
    private Game game;

    @JsonProperty("local_goals")
    private Integer localGoals;

    @JsonProperty("visitor_goals")
    private Integer visitorGoals;
    private Result result;
}
