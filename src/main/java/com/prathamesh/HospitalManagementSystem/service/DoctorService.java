package com.prathamesh.HospitalManagementSystem.service;

import com.prathamesh.HospitalManagementSystem.entity.Doctor;
import com.prathamesh.HospitalManagementSystem.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return  doctorRepo.save(doctor);
    }

    public Doctor getDoctorById(long id) {
        return doctorRepo.getById(id);
    }

    public Doctor updateDoctor(long id, Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public void deleteDoctor(long id) {
        doctorRepo.deleteById(id);
    }
}
