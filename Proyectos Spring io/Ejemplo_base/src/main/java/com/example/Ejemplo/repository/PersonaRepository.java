package com.example.Ejemplo.repository;


import com.example.Ejemplo.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Persona findByNombre(String nombre);

}
