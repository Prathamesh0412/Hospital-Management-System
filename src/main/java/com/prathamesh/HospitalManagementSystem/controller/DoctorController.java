package com.prathamesh.HospitalManagementSystem.controller;

import com.prathamesh.HospitalManagementSystem.entity.Doctor;
import com.prathamesh.HospitalManagementSystem.entity.Patient;
import com.prathamesh.HospitalManagementSystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping()
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id , doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);

    }

}
