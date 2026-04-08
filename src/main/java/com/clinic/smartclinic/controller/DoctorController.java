package com.clinic.smartclinic.controller;

import com.clinic.smartclinic.model.Doctor;
import com.clinic.smartclinic.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors/new")
    public String showDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "add-doctor";
    }

    @PostMapping("/doctors")
    public String saveDoctor(@ModelAttribute Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors")
    public String listDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "view-doctors";
    }

    @GetMapping("/doctors/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "edit-doctor";
    }

    @PostMapping("/doctors/update/{id}")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute Doctor doctor) {
        Doctor existingDoctor = doctorService.getDoctorById(id);

        existingDoctor.setName(doctor.getName());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setAvailableDays(doctor.getAvailableDays());

        doctorService.updateDoctor(existingDoctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/delete/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctorById(id);
        return "redirect:/doctors";
    }
}