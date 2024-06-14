package com.example.Ejemplo.controller;
import com.example.Ejemplo.domain.Persona;
import com.example.Ejemplo.service.PersonaService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/persona")
    public ResponseEntity<Persona> savePersona (@RequestBody Persona persona){
        Persona result = personaService.insertarPersona(persona);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(result);
    }

    @PostMapping("/persona/carrera/{id}")
    public ResponseEntity<Persona> savePersonaCarrera (@PathVariable Long id, @RequestBody Persona persona){

        Persona result = personaService.insertarPersonaCarrera(id, persona);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(result);
    }

    @GetMapping("/persona/all")
    public List<Persona> findAllPersonas (){
        List<Persona>lista = personaService.buscarTodos();
        System.out.println(lista);
        return lista;
    }

    @GetMapping("/persona")
    public Persona findByNombre (@RequestParam("nombre") String nombre){
        return personaService.buscarPersona(nombre);
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Void> deletePersona (@PathVariable Long id){
        personaService.borrarPersona(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/persona/{id}")
    public Persona updatePersona (@PathVariable Long id, @RequestBody Persona persona){
        return personaService.actualizarPersona(id, persona);
    }
}
