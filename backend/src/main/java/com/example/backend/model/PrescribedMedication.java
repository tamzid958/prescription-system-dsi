package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrescribedMedication {
    //use exactly same name and datatype from the jrxml file
    private String medicineName;
    private String dosage;
    private Integer durationInDays;
}
