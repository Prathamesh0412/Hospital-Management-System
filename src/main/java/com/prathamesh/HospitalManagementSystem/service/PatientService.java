package com.prathamesh.HospitalManagementSystem.service;

import com.prathamesh.HospitalManagementSystem.entity.Patient;
import com.prathamesh.HospitalManagementSystem.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public List<Patient> getAllPatients() {
        List<Patient> list = null;
        try {
            list = patientRepo.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Patient getPatientById(@PathVariable long id) {
        return patientRepo.findById(id).get();
    }

    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepo.save(patient);
    }

    public Patient updatePatient(@RequestBody Patient patient) {
        return patientRepo.save(patient);
    }

    public void deletePatientById(@PathVariable long id) {
        patientRepo.deleteById(id);
    }
}
