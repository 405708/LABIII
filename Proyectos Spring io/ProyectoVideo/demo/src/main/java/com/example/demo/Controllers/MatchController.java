package com.example.demo.Controllers;

import com.example.demo.Models.Match;
import com.example.demo.Models.Play;
import com.example.demo.Models.Player;
import com.example.demo.Services.MatchService;
import com.example.demo.dtos.Match.MatchDTO;
import com.example.demo.dtos.play.PlayRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping("")
    public ResponseEntity<Match> saveMatch(@RequestBody @Valid MatchDTO matchDTO){
        Match matchSaved = matchService.createMatch(matchDTO);
        if(Objects.isNull(matchSaved))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en la request");
        }
        else return ResponseEntity.ok(matchSaved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Match> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PostMapping("/{id}/plays/")
    public ResponseEntity<Play> saveMatch(@PathVariable Long id, @RequestBody @Valid PlayRequest playRequest)
    {
        Play playResult = matchService.play(id, playRequest);
        if(Objects.isNull(playResult))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Error en la request");
        }
        else return ResponseEntity.ok(playResult);
    }

}
