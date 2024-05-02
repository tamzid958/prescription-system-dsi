package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    private String fullName;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private List<String> medicalConditions;
    private String bloodGroup;
    private String role;
    private List<String> speciality;
    private String bmdcRegNo;
    private String verificationCode;
    private String Status;
    private String Country;
    private String district;
    private String area;
    private String road;
    private String house;
}
