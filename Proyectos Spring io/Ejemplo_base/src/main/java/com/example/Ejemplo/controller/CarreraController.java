package com.example.Ejemplo.controller;

import com.example.Ejemplo.domain.Carrera;
import com.example.Ejemplo.service.CarreraService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {
    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @PostMapping("/")
    public ResponseEntity<Carrera> save (@RequestBody Carrera carrera){
        Carrera result = carreraService.save(carrera);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(result);
    }

    @GetMapping("/all")
    public List<Carrera> findAll (){
        return carreraService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Carrera> findByid (@PathVariable Long id){
        return carreraService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        carreraService.delete(id);
        return ResponseEntity.ok(null);
    }


}
