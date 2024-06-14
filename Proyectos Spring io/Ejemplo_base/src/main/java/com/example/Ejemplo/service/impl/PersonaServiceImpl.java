package com.example.Ejemplo.service.impl;

import com.example.Ejemplo.domain.Carrera;
import com.example.Ejemplo.domain.Persona;
import com.example.Ejemplo.repository.CarreraRepository;
import com.example.Ejemplo.repository.PersonaRepository;
import com.example.Ejemplo.service.PersonaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final CarreraRepository carreraRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository, CarreraRepository carreraRepository) {
        this.personaRepository = personaRepository;
        this.carreraRepository = carreraRepository;
    }
    @Override
    public Persona insertarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona insertarPersonaCarrera(Long id, Persona persona) {
        Optional<Carrera> carrera = carreraRepository.findById(id);
        persona.setCarrera(carrera.get());
        return personaRepository.save(persona);
    }

    @Override
    public List<Persona> buscarTodos() {
        return personaRepository.findAll();
    }

    @Override
    public Persona buscarPersona(String nombre) {
       return personaRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Persona> buscarPersona(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona actualizarPersona(Long id, Persona persona) {
        Optional<Persona> base = personaRepository.findById(id);
        if(base.isPresent()){
            base.get().setNombre(persona.getNombre());
            base.get().setApellido(persona.getApellido());
            base.get().setEdad(persona.getEdad());
            return personaRepository.save(base.get());
        }
        else
            return personaRepository.save(persona);
    }
}
