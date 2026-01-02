package com.prathamesh.HospitalManagementSystem.repository;

import com.prathamesh.HospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

    @Query("""
        SELECT COUNT(a) > 0 FROM Appointment a
        WHERE a.doctor.id = :doctorId
        AND a.date = :date
        AND :startTime < a.endTime
        AND :endTime > a.startTime
    """)

    boolean existsOverlappingAppointment(Long doctorId, LocalDate date, LocalTime startTime, LocalTime endTime);

}
