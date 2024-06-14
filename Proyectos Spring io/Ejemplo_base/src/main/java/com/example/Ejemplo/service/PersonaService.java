package com.example.Ejemplo.service;

import com.example.Ejemplo.domain.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona insertarPersona(Persona persona);
    Persona insertarPersonaCarrera(Long id, Persona persona);
    List<Persona> buscarTodos();
    Persona buscarPersona(String nombre);
    Optional<Persona> buscarPersona(Long id);
    void borrarPersona(Long id);
    Persona actualizarPersona(Long id, Persona persona);
}
