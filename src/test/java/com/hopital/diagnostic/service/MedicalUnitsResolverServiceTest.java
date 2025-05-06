package com.hopital.diagnostic.service;

import com.hopital.diagnostic.service.impl.MedicalUnitsResolverServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicalUnitsResolverServiceTest extends AbstractServiceTest{


    private final MedicalUnitsResolverService medicalUnitsResolverService = new MedicalUnitsResolverServiceImpl();

    @Test
    @DisplayName("Doit retourner 'Cardiologie' si l'index est divisible par 3 uniquement")
    void testShouldReturnCardiologieWhenIndexDivisibleBy3() {
        assertEquals("Cardiologie", medicalUnitsResolverService.resolveUnits(33));
    }

    @Test
    @DisplayName("Doit retourner 'Traumatologie' si l'index est divisible par 5 uniquement")
    void testShouldReturnTraumatologieWhenIndexDivisibleBy5() {
        assertEquals("Traumatologie", medicalUnitsResolverService.resolveUnits(55));
    }

    @Test
    @DisplayName("Doit retourner 'Cardiologie, Traumatologie' si l'index est divisible par 3 et 5")
    void testShouldReturnCardiologieAndTraumatologieWhenIndexDivisibleBy3And5() {
        assertEquals("Cardiologie, Traumatologie", medicalUnitsResolverService.resolveUnits(15));
    }

    @Test
    @DisplayName("Doit retourner 'Aucune pathologie détectée' si l'index n'est divisible ni par 3 ni par 5")
    void testShouldReturnAucunepathologiedétectéeWhenIndexNotDivisibleBy3And5() {
        assertEquals("Aucune pathologie détectée", medicalUnitsResolverService.resolveUnits(7));
    }
}
