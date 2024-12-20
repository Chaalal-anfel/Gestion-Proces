package com.example.process_permis_conduite.repository;

// Repository pour Proces
import com.example.process_permis_conduite.entities.Proces;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProcesRepository extends JpaRepository<Proces, Long> {}
