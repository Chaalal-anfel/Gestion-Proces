package com.example.process_permis_conduite.dto;
// DTO pour Vehicule
import com.example.process_permis_conduite.entities.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculeDTO {
    private String matricule;
    private String assurance;
    private String carteGrise;
    private String citoyenNin; // Référence au citoyen
}
