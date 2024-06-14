package com.example.Ejemplo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "personas")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private int edad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carrera_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Carrera carrera;
}
