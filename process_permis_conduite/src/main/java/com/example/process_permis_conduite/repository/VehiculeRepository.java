package com.example.process_permis_conduite.repository;

// Repository pour Vehicule
import com.example.process_permis_conduite.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, String> {}
