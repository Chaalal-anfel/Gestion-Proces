package com.example.process_permis_conduite.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Vehicule {
    @Id
    private String matricule;

    private String assurance;
    private String carteGrise;

    @ManyToOne
    @JoinColumn(name = "citoyen_nin")
    private Citoyen citoyen;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    private List<Proces> procesList = new ArrayList<>();
}

