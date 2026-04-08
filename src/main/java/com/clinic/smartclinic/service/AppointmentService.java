package com.clinic.smartclinic.service;

import com.clinic.smartclinic.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointmentById(Long id);
}