package com.example.backend.service;

import com.example.backend.dto.NewMedicationDto;
import com.example.backend.entity.Medication;
import com.example.backend.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;

//    public Medication addNewMedication(NewMedicationDto medicationDto){
//
//    }
}
