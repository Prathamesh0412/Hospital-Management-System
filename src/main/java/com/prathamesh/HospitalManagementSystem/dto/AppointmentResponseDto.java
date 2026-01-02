package com.prathamesh.HospitalManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentResponseDto {


    private Long appointmentId;
    private Long doctorId;
    private String patientName;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
}
