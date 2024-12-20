package com.example.process_permis_conduite.dto;

import com.example.process_permis_conduite.entities.PermisDeConduire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PermisDeConduireDTO {
    private String numeroPermis;
    private Date dateEmission;
    private String typePermis;
    private String statusPermis;
    private String citoyenNin; // Référence au citoyen
}
