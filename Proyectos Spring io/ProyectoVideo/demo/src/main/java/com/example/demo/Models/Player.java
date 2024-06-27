package com.example.demo.Models;

import com.example.demo.Utils.Validations.password.ValidPassword;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(title = "Player ID", description = "La ID del Player", example = "1")
    Long id;

    @Schema(title = "Player username", description = "username del Player", example = "bananirou", nullable = false)
    @NotNull(message = "Username no puede estar vacio")
    String userName;

    @Schema(title = "Player password", description = "password del Player", example = "Elsalto01#", nullable = false)
    @NotNull(message = "Password no puede estar vacia")
    @ValidPassword  //Anotacion generada por nosotros
    String password;

    @Schema(title = "Player email", description = "email del Player", example = "delpapu@email.com", nullable = false)
    @NotNull(message = "Email no puede estar vacio")
    @Email(message = "El email es invalido")
    String email;

    @Schema(title = "Player avatar url", description = "url del avatar del Player", example = "https://localhost:8080/avatars/myUsername", nullable = true)
    String avatar;

    @Schema(title = "Player lastLogin", description = "Ultimo logueo Player", example = "27-06-2024 18:37:53", nullable = true)
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    LocalDateTime lastLogin;
}
