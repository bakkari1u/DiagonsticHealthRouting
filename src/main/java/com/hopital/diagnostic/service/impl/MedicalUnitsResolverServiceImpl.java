package com.hopital.diagnostic.service.impl;

import com.hopital.diagnostic.enumerator.MedicalUnit;
import com.hopital.diagnostic.service.MedicalUnitsResolverService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalUnitsResolverServiceImpl implements MedicalUnitsResolverService {


    @Override
    public String resolveUnits(int index) {
        List <MedicalUnit> units = new ArrayList<>();

        if (index % 3 == 0) {
            units.add(MedicalUnit.CARDIOLOGIE);
        }
        if (index % 5 == 0) {
            units.add(MedicalUnit.TRAUMATOLOGIE);
        }

        if (units.isEmpty()) {
            return "Aucune pathologie détectée";
        }

        return units.stream()
                .map(MedicalUnit::getLibelle)
                .collect(Collectors.joining(", "));
    }
}
