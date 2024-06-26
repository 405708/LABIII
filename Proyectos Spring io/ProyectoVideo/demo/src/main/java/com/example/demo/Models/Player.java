package com.example.demo.Models;

import com.example.demo.Utils.Validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {


    Long id;

    @NotNull(message = "Username no puede estar vacio")
    String userName;

    @NotNull(message = "Password no puede estar vacia")
    @ValidPassword  //Anotacion generada por nosotros
    String password;

    @NotNull(message = "Email no puede estar vacio")
    @Email(message = "El email es invalido")
    String email;

    String avatar;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    LocalDateTime lastLogin;
}
