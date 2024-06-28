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
public class UserNameIdentity extends Identity {
    @Schema(title = "userName para loguearse",
            description = "El userName usado para loguearse",
            example = "userName",
            nullable = false)
    @NotNull(message = "userName no puede ser null")
    @JsonProperty("user_name")
    private String userName;
}
