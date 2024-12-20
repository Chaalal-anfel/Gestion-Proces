package com.example.process_permis_conduite.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data // Génère les getters, setters, equals, hashCode, toString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Citoyen {
    @Id
    private String nin;

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String numeroTel;
    private String login;
    private String password;

    @OneToOne(mappedBy = "citoyen", cascade = CascadeType.ALL)
    private PermisDeConduire permisDeConduire;

    @OneToMany(mappedBy = "citoyen", cascade = CascadeType.ALL)
    private List<Vehicule> vehicules = new ArrayList<>();
}


