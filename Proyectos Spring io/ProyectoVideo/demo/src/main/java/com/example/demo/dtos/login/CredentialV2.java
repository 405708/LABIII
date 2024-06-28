package com.example.demo.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialV2 {

    @Schema(title = "Email o Username para loguearse",
            description = "el email o usuario",
            example = "email@email.com o username",
            nullable = false)
    @NotNull(message = "Identity no puede ser null")
    @JsonProperty("identity")
    private String identity;
    @NotNull(message = "Password no puede ser null")
    @JsonProperty("password")
    private String password;
}
