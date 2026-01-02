package com.prathamesh.HospitalManagementSystem.controller;

import com.prathamesh.HospitalManagementSystem.dto.AppointmentRequestDto;
import com.prathamesh.HospitalManagementSystem.dto.AppointmentResponseDto;
import com.prathamesh.HospitalManagementSystem.entity.Appointment;
import com.prathamesh.HospitalManagementSystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponseDto> bookAppointment(@RequestBody AppointmentRequestDto  appointmentRequestDto) {
        AppointmentResponseDto appointmentResponseDto = appointmentService.bookAppointment(appointmentRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentResponseDto);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }


}
