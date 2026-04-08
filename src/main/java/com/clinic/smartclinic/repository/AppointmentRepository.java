package com.clinic.smartclinic.repository;

import com.clinic.smartclinic.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}