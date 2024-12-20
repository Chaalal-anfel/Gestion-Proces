package com.example.process_permis_conduite.repository;

// Repository pour Citoyen
import com.example.process_permis_conduite.entities.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitoyenRepository extends JpaRepository<Citoyen, String> {}
