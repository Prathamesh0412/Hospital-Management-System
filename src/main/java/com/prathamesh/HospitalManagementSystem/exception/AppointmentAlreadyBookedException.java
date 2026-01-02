package com.prathamesh.HospitalManagementSystem.exception;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentAlreadyBookedException extends RuntimeException {

    public AppointmentAlreadyBookedException(Long doctorId, LocalDate date , LocalTime startTime , LocalTime endTime) {
        super("Appointment Already booked between time "+startTime.toString()+" and "+endTime.toString()+" on date "+date.toString());

    }

}
