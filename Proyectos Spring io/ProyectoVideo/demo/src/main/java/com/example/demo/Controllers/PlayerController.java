package com.example.demo.Controllers;

import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Player;
import com.example.demo.Services.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @PostMapping("")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player) //El body que viene debe ser valido
    {
        return ResponseEntity.ok(playerService.savePlayer(player));
    }

}
