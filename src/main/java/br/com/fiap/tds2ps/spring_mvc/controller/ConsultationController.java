
package br.com.fiap.tds2ps.spring_mvc.controller;

import br.com.fiap.tds2ps.spring_mvc.dto.PersonDto;
import br.com.fiap.tds2ps.spring_mvc.domain.Patient;
import br.com.fiap.tds2ps.spring_mvc.service.PatientService;
import br.com.fiap.tds2ps.spring_mvc.service.ConsultationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultationController {
    private final PatientService patientService;
    private final ConsultationService consultationService;

    public ConsultationController(PatientService patientService, ConsultationService consultationService) {
        this.patientService = patientService;
        this.consultationService = consultationService;
    }

    @PostMapping("/consultation/start")
    public ModelAndView start(Model model, @ModelAttribute("patientLazy") PersonDto patientDto) {
        Patient patient = patientService.findOrCreatePatient(patientDto.getCpf());
        consultationService.createConsultation(patient);
        return new ModelAndView("add-consultation");
    }
}
