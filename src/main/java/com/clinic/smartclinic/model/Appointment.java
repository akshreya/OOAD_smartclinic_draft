package com.clinic.smartclinic.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;
    private String status;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    public Appointment() {
    }

    public Appointment(LocalDate appointmentDate, String status, Doctor doctor, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}