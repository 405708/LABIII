package ar.edu.utn.frc.tup.lc.iii.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ScoreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getScoresTest() throws Exception {
        this.mockMvc.perform(get("/scores")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));
    }

}