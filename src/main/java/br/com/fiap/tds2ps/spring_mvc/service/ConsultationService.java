package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.domain.Consultation;
import br.com.fiap.tds2ps.spring_mvc.domain.Patient;
import br.com.fiap.tds2ps.spring_mvc.repository.ConsultationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ConsultationService {
    private final ConsultationRepository consultationRepository;

    public ConsultationService(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Consultation createConsultation(Patient patient) {
        Consultation consultation = new Consultation();
        consultation.setPatient(patient);
        consultation.setDate(LocalDateTime.now());
        return consultationRepository.save(consultation);
    }
}
