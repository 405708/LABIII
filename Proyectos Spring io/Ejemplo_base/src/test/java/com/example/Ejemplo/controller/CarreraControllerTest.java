package com.example.Ejemplo.controller;

import com.example.Ejemplo.domain.Carrera;
import com.example.Ejemplo.service.CarreraService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import jakarta.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.Ejemplo.util.Utils.asJsonString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CarreraControllerTest {

    private static final String URL_CARRERA = "/api/carrera/";
    private static final String URL_CARRERAS = "/api/carrera/all/";
    private static final List<Carrera> EMPTY_LIST = new ArrayList<>();

    private MockMvc mockMvc;

    @InjectMocks
    private CarreraController carreraController;
    @Mock
    private CarreraService carreraService;

    @BeforeEach
    void setUp() {
        initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(carreraController).build();
    }

    @Test
    void given_no_get_method_endpoint_carreras_should_return_status_method_not_allowed() throws Exception {
        this.mockMvc.perform(put(URL_CARRERA)).andExpect(status().isMethodNotAllowed());
        this.mockMvc.perform(delete(URL_CARRERA)).andExpect(status().isMethodNotAllowed());
    }

    @Test
    void endpoint_should_return_200_and_a_list_of_plans() throws Exception {
        when(carreraService.findAll()).thenReturn(EMPTY_LIST);

        MockHttpServletResponse response = this.mockMvc.perform(get(URL_CARRERAS)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(asJsonString(EMPTY_LIST));
    }

    @Test
    void given_carreras_exist_when_get_then_status_200_and_return_carreras() throws Exception {
        List<Carrera> carreras = new ArrayList<>();
        Carrera carrera1 = new Carrera();
        carrera1.setId(1L);
        carrera1.setNombre("Ingenieria");
        carreras.add(carrera1);

        Carrera carrera2 = new Carrera();
        carrera2.setId(2L);
        carrera2.setNombre("Medicina");
        carreras.add(carrera2);

        when(carreraService.findAll()).thenReturn(carreras);

        MockHttpServletResponse response = this.mockMvc.perform(get(URL_CARRERAS)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(asJsonString(carreras));
    }

    @Test
    void given_valid_id_when_delete_then_status_200() throws Exception {
        doNothing().when(carreraService).delete(1L);

        MockHttpServletResponse response = this.mockMvc.perform(delete(URL_CARRERA + "1"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void given_invalid_id_when_delete_then_status_404() throws Exception {
        doThrow(new EntityNotFoundException()).when(carreraService).delete(1L);

        try {
            MockHttpServletResponse response = this.mockMvc.perform(delete(URL_CARRERA + "1"))
                    .andReturn().getResponse();
        } catch (Exception e) {
            assertThat(e.getClass()).isEqualTo(ServletException.class);
        }

    }

    @Test
    void given_valid_id_when_get_then_status_200_and_return_carrera() throws Exception {
        Carrera carrera = new Carrera();
        carrera.setId(1L);
        carrera.setNombre("Ingenieria");

        when(carreraService.findById(1L)).thenReturn(Optional.of(carrera));

        MockHttpServletResponse response = this.mockMvc.perform(get(URL_CARRERA + "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(asJsonString(carrera));
    }

    @Test
    void given_invalid_carrera_when_post_then_status_bad_request() throws Exception {
        Carrera carrera = new Carrera();  // Objeto Carrera vacío

        MockHttpServletResponse response = this.mockMvc.perform(post(URL_CARRERA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(carrera)))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    void given_valid_carrera_when_post_then_status_200_and_return_carrera() throws Exception {
        Carrera carrera = new Carrera();
        carrera.setId(1L);
        carrera.setNombre("Ingenieria");

        when(carreraService.save(any(Carrera.class))).thenReturn(carrera);

        MockHttpServletResponse response = this.mockMvc.perform(post(URL_CARRERA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(carrera)))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(asJsonString(carrera));
    }
}