package com.example.process_permis_conduite.dto;


import com.example.process_permis_conduite.entities.Proces;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ProcesDTO {
    private Long id;
    private String typeProces;
    private String lieu;
    private LocalDateTime date;
    private String source;
    private Double montantAPayer;
    private String etatProces;
    private String permisNumero; // Référence au permis
    private String vehiculeMatricule; // Référence au véhicule
}
