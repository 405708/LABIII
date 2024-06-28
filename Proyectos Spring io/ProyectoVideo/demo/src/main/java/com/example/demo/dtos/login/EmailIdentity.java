package com.example.demo.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailIdentity extends Identity{
    @Schema(title = "Email para loguearse",
            description = "El email usado para loguearse",
            example = "email@email.com",
            nullable = false)
    @NotNull(message = "email no puede ser null")
    @JsonProperty("email")
    private String email;
}
