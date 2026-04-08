package com.clinic.smartclinic.repository;

import com.clinic.smartclinic.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}