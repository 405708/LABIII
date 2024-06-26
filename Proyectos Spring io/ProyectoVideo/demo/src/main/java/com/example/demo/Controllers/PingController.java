package com.example.demo.Controllers;

import com.example.demo.dtos.Common.ErrorApi;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Operation(
            summary = "Revisar que la app este corriendo",
            description = "Si la app esta corriendo retornara pong")
    @ApiResponses(value = {
                 @ApiResponse(
                         responseCode = "200",
                         description = "Operacion realizada con exito",
                         content = @Content(
                                 schema = @Schema(implementation = String.class)
                         )
                 ),
                 @ApiResponse(
                         responseCode = "500",
                         description = "Internal Server Error",
                         content = @Content(
                                 schema = @Schema(implementation = ErrorApi.class)
                         )
                 )
            }
    )

    @GetMapping("/ping")
    public String pong()
    {
        return "pong";
    }
}
