package com.hopital.diagnostic.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HealthroutingControllerTest extends AbstarctControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String BASE_URL = "/api/health-routing";


    @Test
    @DisplayName("Doit retourner 'Cardiologie' si l'index est divisible par 3 uniquement")
    void testEndpointshouldReturnCardiologyWhenIndexDivisibleBy3Only() throws Exception {
        mockMvc.perform(get(BASE_URL + "/33"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cardiologie"));
    }

    @Test
    @DisplayName("Doit retourner 'Traumatologie' si l'index est divisible par 5 uniquement")
    void testEndpointshouldReturnTraumatologyWhenIndexDivisibleBy5Only() throws Exception {
        mockMvc.perform(get(BASE_URL + "/55"))
                .andExpect(status().isOk())
                .andExpect(content().string("Traumatologie"));
    }

    @Test
    @DisplayName("Doit retourner 'Cardiologie, Traumatologie' si l'index est divisible par 3 et 5")
    void testEndpointshouldReturnBothUnitsWhenIndexDivisibleBy3And5() throws Exception {
        mockMvc.perform(get(BASE_URL + "/15"))
                .andExpect(status().isOk())
                .andExpect(content().string("Cardiologie, Traumatologie"));
    }

    @Test
    @DisplayName("Doit retourner 'Aucune pathologie détectée' si l'index n'est divisible ni par 3 ni par 5")
    void testEndpointshouldReturnNoPathologyWhenIndexNotDivisibleBy3Or5() throws Exception {
        mockMvc.perform(get(BASE_URL + "/7"))
                .andExpect(status().isOk())
                .andExpect(content().string("Aucune pathologie détectée"));
    }

    @Test
    @DisplayName("Doit retourner 'L'index doit être un entier valide' si l'index n'est pas un entier")
    void testEndpointshouldReturn400WhenIndexIsNotInteger() throws Exception {
        mockMvc.perform(get(BASE_URL + "/abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("L'index doit être un entier valide (ex : 15, 33)."));
    }

}
