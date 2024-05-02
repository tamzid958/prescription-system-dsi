package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private User doctor; //doctor
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private User patient; //patient
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinic_id")
    @JsonBackReference
    private Clinic clinic;
    private String referredBy;
    private List<String> complaints;
    private List<String> clinicalFindings;
    private String diagnosis;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medication_id")
    private Medication medication;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Test> tests;
    private List<String> specialInstruction;
    private List<String> additionalNotes;
    @CreationTimestamp
    private LocalDate createdAt;
}
