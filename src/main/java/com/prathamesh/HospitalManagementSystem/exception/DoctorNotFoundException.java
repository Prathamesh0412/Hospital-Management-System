package com.prathamesh.HospitalManagementSystem.exception;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(Long doctorId) {
        super("Doctor with id " + doctorId + " not found");
    }


}
