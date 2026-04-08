package com.clinic.smartclinic.service;

import com.clinic.smartclinic.model.Patient;
import com.clinic.smartclinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}