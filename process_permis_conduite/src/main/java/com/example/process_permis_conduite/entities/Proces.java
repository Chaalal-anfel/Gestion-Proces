package com.example.process_permis_conduite.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@Data

@Entity
public class Proces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeProces;
    private String lieu;
    private LocalDateTime date;
    private String source;
    private Double montantAPayer;
    private String etatProces;

    @ManyToOne
    @JoinColumn(name = "permis_numero")
    private PermisDeConduire permis;

    @ManyToOne
    @JoinColumn(name = "vehicule_matricule")
    private Vehicule vehicule;
}

