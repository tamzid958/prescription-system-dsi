package com.example.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NewMedicineDto {
    @NotBlank(message = "Medicine must have a name")
    private String name;
    private String doseStrength;
    private String state;
    @NotBlank(message = "Medicine must have a brand")
    private String brand;
}
