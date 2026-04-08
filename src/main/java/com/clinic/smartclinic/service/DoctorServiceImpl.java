package com.clinic.smartclinic.service;

import com.clinic.smartclinic.model.Doctor;
import com.clinic.smartclinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}