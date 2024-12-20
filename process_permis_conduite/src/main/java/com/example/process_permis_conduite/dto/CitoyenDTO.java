package com.example.process_permis_conduite.dto;


import com.example.process_permis_conduite.entities.Citoyen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CitoyenDTO {
    private String nin;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroTel;
    private String login;
    private String permisNumero; // Référence au permis de conduire
}
