package com.example.demo.Controllers;

import com.example.demo.Entities.PlayerEntity;
import com.example.demo.Models.Player;
import com.example.demo.Services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.plaf.metal.MetalBorders;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @Test
    public void getByIdTest() throws Exception {

        Player player = new Player();
        player.setId(1L);
        player.setEmail("email@email.com");
        player.setUserName("martin");
        player.setPassword("Password03#");

        when(playerService.getPlayerById(1L)).thenReturn(player);
        this.mockMvc.perform(get("/players/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.userName").value("martin"))
                .andExpect(jsonPath("$.email").value("email@email.com"))
                .andExpect(jsonPath("$.password").value("Password03#"));
    }

    @Test
    public void savePlayerTest() throws Exception{

    }
}