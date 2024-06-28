package com.example.demo.Controllers;

import com.example.demo.Models.Player;
import com.example.demo.Services.LoginService;
import com.example.demo.dtos.Common.ErrorApi;
import com.example.demo.dtos.login.Credential;
import com.example.demo.dtos.login.CredentialV2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(
            summary = "Logueo",
            description = "Para loguearse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion realizada con exito",
                    content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class)))
    })

    @PostMapping("/v1")
    public ResponseEntity<Player> loginPlayer(@RequestBody @Valid Credential credential)
    {
        return ResponseEntity.ok(loginService.login(credential));
    }


    @Operation(
            summary = "Logueo v2",
            description = "Para loguearse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operacion realizada con exito",
                    content = @Content(schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorApi.class)))
    })

    @PostMapping("v2")
    public ResponseEntity<Player> loginPlayer(@RequestBody @Valid CredentialV2 credentialv2)
    {
        return ResponseEntity.ok(loginService.login(credentialv2));
    }


}
