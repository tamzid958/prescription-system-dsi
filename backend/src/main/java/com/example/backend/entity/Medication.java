package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dosage;
    private int duration;
    private int frequency;
    private int quantity;
    private List<String> instructions;
    @OneToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Medicine> medicines;

}

