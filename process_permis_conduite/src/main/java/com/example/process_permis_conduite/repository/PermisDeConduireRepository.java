package com.example.process_permis_conduite.repository;

// Repository pour PermisDeConduire
import com.example.process_permis_conduite.entities.PermisDeConduire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisDeConduireRepository extends JpaRepository<PermisDeConduire, String> {}

