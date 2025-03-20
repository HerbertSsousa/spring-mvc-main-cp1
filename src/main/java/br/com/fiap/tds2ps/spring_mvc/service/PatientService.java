package br.com.fiap.tds2ps.spring_mvc.service;

import br.com.fiap.tds2ps.spring_mvc.domain.Patient;
import br.com.fiap.tds2ps.spring_mvc.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient findOrCreatePatient(String cpf) {
        return patientRepository.findByCpf(cpf).orElseGet(() -> {
            Patient newPatient = new Patient();
            newPatient.setCpf(cpf);
            return patientRepository.save(newPatient);
        });
    }
}