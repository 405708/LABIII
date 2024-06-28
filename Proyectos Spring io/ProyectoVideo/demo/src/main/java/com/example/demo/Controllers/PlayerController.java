package com.example.demo.Controllers;

import com.example.demo.Models.Match;
import com.example.demo.Services.MatchService;
import com.example.demo.dtos.Common.ErrorApi;
import com.example.demo.Models.Player;
import com.example.demo.Services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private MatchService matchService;

    @Operation(
            summary = "Traer un Player por ID",
            description = "Retorna un Player si existe su ID, sino retorna error 404")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion realizada con exito",
                    content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class)))
    })

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @Operation(
            summary = "Crear un nuevo Player",
            description = "Retorna el Player creado con la id, " +
                    "si ya existe ese username o email retorna 400" +
                    "Ademas el email debe ser valido y la Password contener:" +
                    "8 caracteres, una minuscula, una mayus y una especial")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion realizada con exito",
                    content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Username o Email ya existente",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class)))
    })

    @PostMapping("")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player) //El body que viene debe ser valido
    {
        Player playerSaved = playerService.savePlayer(player);
        if(Objects.isNull(playerSaved)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username o email ya existe");
        }
        else return ResponseEntity.ok(playerSaved);
    }

    @GetMapping("/{id}/matches")
    public ResponseEntity<List<Match>> getMatchesOfPlayer(@PathVariable Long id)
    {
        List<Match> matches = matchService.getMatchByPlayer(id);
        return ResponseEntity.ok(matches);
    }

}
