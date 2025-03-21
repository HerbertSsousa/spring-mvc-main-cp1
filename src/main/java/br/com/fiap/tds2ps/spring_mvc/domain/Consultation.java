package br.com.fiap.tds2ps.spring_mvc.domain;
 
import jakarta.persistence.*;

import java.time.LocalDateTime;
 
@Entity

public class Consultation {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
 
    @ManyToOne

    @JoinColumn(name = "patient_id", nullable = false)

    private Patient patient;
 
    private LocalDateTime date;
 
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public LocalDateTime getDate() { return date; }

    public void setDate(LocalDateTime date) { this.date = date; }

}
 
