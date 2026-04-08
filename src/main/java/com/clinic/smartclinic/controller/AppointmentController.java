package com.clinic.smartclinic.controller;

import com.clinic.smartclinic.model.Appointment;
import com.clinic.smartclinic.service.AppointmentService;
import com.clinic.smartclinic.service.DoctorService;
import com.clinic.smartclinic.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public AppointmentController(AppointmentService appointmentService,
                                 DoctorService doctorService,
                                 PatientService patientService) {
        this.appointmentService = appointmentService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "view-appointments";
    }

    @GetMapping("/appointments/new")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("patients", patientService.getAllPatients());
        return "add-appointment";
    }

    @PostMapping("/appointments")
    public String saveAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        model.addAttribute("appointment", appointment);
        model.addAttribute("doctors", doctorService.getAllDoctors());
        model.addAttribute("patients", patientService.getAllPatients());
        return "edit-appointment";
    }

    @PostMapping("/appointments/update/{id}")
    public String updateAppointment(@PathVariable Long id, @ModelAttribute Appointment appointment) {
        Appointment existingAppointment = appointmentService.getAppointmentById(id);

        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setStatus(appointment.getStatus());
        existingAppointment.setDoctor(appointment.getDoctor());
        existingAppointment.setPatient(appointment.getPatient());

        appointmentService.updateAppointment(existingAppointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        return "redirect:/appointments";
    }
}