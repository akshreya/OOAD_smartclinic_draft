package com.clinic.smartclinic.controller;

import com.clinic.smartclinic.model.Patient;
import com.clinic.smartclinic.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "view-patients";
    }

    @GetMapping("/patients/new")
    public String showPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/patients")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "edit-patient";
    }

    @PostMapping("/patients/update/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute Patient patient) {
        Patient existingPatient = patientService.getPatientById(id);

        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setPhone(patient.getPhone());
        existingPatient.setEmail(patient.getEmail());

        patientService.updatePatient(existingPatient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatientById(id);
        return "redirect:/patients";
    }
}