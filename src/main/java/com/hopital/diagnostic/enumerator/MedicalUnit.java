package com.hopital.diagnostic.enumerator;

import lombok.Getter;

@Getter
public enum MedicalUnit {
    CARDIOLOGIE("Cardiologie"),
    TRAUMATOLOGIE("Traumatologie");

    private final String libelle;

    MedicalUnit(final String libelle) {
        this.libelle = libelle;
    }

}
