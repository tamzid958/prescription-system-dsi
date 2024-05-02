package com.example.backend.controller;

import com.example.backend.dto.NewMedicineDto;
import com.example.backend.entity.Medicine;
import com.example.backend.service.MedicineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @PostMapping
    public ResponseEntity<Medicine> addNewMedicine(@Valid @RequestBody NewMedicineDto newMedicineDto) {
        Medicine savedMedicine = medicineService.addNewMedicine(newMedicineDto);
        return new ResponseEntity<>(savedMedicine, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Medicine>> getAllMedicine() {
        return ResponseEntity.ok(medicineService.getAllMedicine());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Medicine>> getMedicine(Pageable pageable, Sort sort)  {
        Pageable paginationCriteria = PageRequest.of(pageable.getPageNumber()-1, pageable.getPageSize(), sort);
        return ResponseEntity.ok(medicineService.getMedicines(paginationCriteria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getMedicineById(id));
    }
}
