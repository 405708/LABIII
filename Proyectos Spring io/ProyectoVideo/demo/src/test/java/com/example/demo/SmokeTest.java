package com.example.demo;

import com.example.demo.Controllers.ControllerExceptionHandler;
import com.example.demo.Controllers.PingController;
import com.example.demo.Controllers.PlayerController;
import com.example.demo.Services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private PlayerController playerController;
    @Autowired
    private PingController pingController;
    @Autowired
    private PlayerService playerService;
    @Test
    public void contextLoads() throws Exception{
        assertThat(playerController).isNotNull();
        assertThat(pingController).isNotNull();
        assertThat(playerService).isNotNull();
    }
}
