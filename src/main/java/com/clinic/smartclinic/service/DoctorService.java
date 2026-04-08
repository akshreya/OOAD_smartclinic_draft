package com.clinic.smartclinic.service;

import com.clinic.smartclinic.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long id);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctorById(Long id);
}