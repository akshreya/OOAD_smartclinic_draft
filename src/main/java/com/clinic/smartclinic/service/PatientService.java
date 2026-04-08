package com.clinic.smartclinic.service;

import com.clinic.smartclinic.model.Patient;
import java.util.List;

public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient updatePatient(Patient patient);
    void deletePatientById(Long id);
}