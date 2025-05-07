package com.hopital.diagnostic.controller;


import com.hopital.diagnostic.service.MedicalUnitsResolverService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestController
@RequestMapping("/api/health-routing")
@RequiredArgsConstructor
public class HealthRoutingController {

    private final MedicalUnitsResolverService medicalUnitsResolverService;


    @Operation(summary = "Obtenir l'unité médicale correspondante à un index de santé")
    @GetMapping("/{index}")
    public ResponseEntity<String> getUnits(@PathVariable int index) {
        String unit =  medicalUnitsResolverService.resolveUnits(index);
        return ResponseEntity.ok(unit);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity
                .badRequest()
                .body("L'index doit être un entier valide (ex : 15, 33).");
    }
}
