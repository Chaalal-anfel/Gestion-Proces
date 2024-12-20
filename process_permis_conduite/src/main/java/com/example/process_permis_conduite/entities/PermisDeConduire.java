package com.example.process_permis_conduite.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PermisDeConduire {
    @Id
    private String numeroPermis;

    private Date dateEmission;
    private String typePermis;
    private String statusPermis;

    @OneToOne
    @JoinColumn(name = "citoyen_nin")
    private Citoyen citoyen;

    @OneToMany(mappedBy = "permis", cascade = CascadeType.ALL)
    private List<Proces> procesList;
}