package com.example.backend.service;

import com.example.backend.dto.NewMedicineDto;
import com.example.backend.entity.Medicine;
import com.example.backend.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.beans.MethodDescriptor;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public Medicine addNewMedicine(NewMedicineDto newMedicineDto) {
        Medicine medicine = mapNewMedicineDtoToMedicine(newMedicineDto);
        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicine() {
        return medicineRepository.findAll();
    }

    public Page<Medicine> getMedicines(Pageable pageable) {
        return medicineRepository.findAll(pageable);
    }

    public Medicine getMedicineById(Long id) {
        return medicineRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No medicine has been found with id " + id));
    }

    public Medicine mapNewMedicineDtoToMedicine(NewMedicineDto newMedicineDto) {
        Medicine medicine = new Medicine();
        medicine.setName(newMedicineDto.getName());
        medicine.setDoseStrength(newMedicineDto.getDoseStrength());
        medicine.setState(newMedicineDto.getState());
        medicine.setBrand(newMedicineDto.getBrand());
        return medicine;
    }

}
