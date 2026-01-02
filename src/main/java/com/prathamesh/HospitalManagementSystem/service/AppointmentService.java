package com.prathamesh.HospitalManagementSystem.service;

import com.prathamesh.HospitalManagementSystem.dto.AppointmentRequestDto;
import com.prathamesh.HospitalManagementSystem.dto.AppointmentResponseDto;
import com.prathamesh.HospitalManagementSystem.entity.Appointment;
import com.prathamesh.HospitalManagementSystem.entity.Doctor;
import com.prathamesh.HospitalManagementSystem.exception.AppointmentAlreadyBookedException;
import com.prathamesh.HospitalManagementSystem.exception.DoctorNotFoundException;
import com.prathamesh.HospitalManagementSystem.repository.AppointmentRepo;
import com.prathamesh.HospitalManagementSystem.repository.DoctorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Transactional
    public AppointmentResponseDto  bookAppointment(AppointmentRequestDto appointmentRequestDto) {
        Doctor doctor = doctorRepo.findById(appointmentRequestDto.getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(appointmentRequestDto.getDoctorId()));

        boolean hasOverlap =
                appointmentRepo.existsOverlappingAppointment(
                        doctor.getId(),
                        appointmentRequestDto.getDate(),
                        appointmentRequestDto.getStartTime(),
                        appointmentRequestDto.getEndTime()
                );

        if(hasOverlap) {
            throw new AppointmentAlreadyBookedException(doctor.getId(),
                    appointmentRequestDto.getDate(),
                    appointmentRequestDto.getStartTime(),
                    appointmentRequestDto.getEndTime());
        }

        Appointment appointment = new Appointment();

        appointment.setDoctor(doctor);
        appointment.setPatientName(appointmentRequestDto.getPatientName());
        appointment.setDate(appointmentRequestDto.getDate());
        appointment.setStartTime(appointmentRequestDto.getStartTime());
        appointment.setEndTime(appointmentRequestDto.getEndTime());

        Appointment saved = appointmentRepo.save(appointment);

        AppointmentResponseDto response = new AppointmentResponseDto();

        response.setAppointmentId(saved.getId());
        response.setDoctorId(doctor.getId());
        response.setPatientName(saved.getPatientName());
        response.setDate(saved.getDate());
        response.setStartTime(saved.getStartTime());
        response.setEndTime(saved.getEndTime());

        return response;
    }


    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }


}



