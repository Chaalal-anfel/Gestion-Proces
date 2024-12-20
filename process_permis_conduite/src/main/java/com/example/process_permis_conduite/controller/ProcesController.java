package com.example.process_permis_conduite.controller;


import com.example.process_permis_conduite.dto.ProcesDTO;
import com.example.process_permis_conduite.entities.Proces;
import com.example.process_permis_conduite.repository.ProcesRepository;
import com.example.process_permis_conduite.service.ProcesService;
import com.example.process_permis_conduite.uses.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/proces")
public class ProcesController {
    @Autowired
    private ProcesService procesService;

    @PostMapping
    public ResponseEntity<ProcesDTO> create(@RequestBody ProcesDTO dto) {
        return ResponseEntity.ok(procesService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProcesDTO> update(@PathVariable Long id, @RequestBody ProcesDTO dto) {
        return ResponseEntity.ok(procesService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        procesService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcesDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(procesService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProcesDTO>> getAll() {
        return ResponseEntity.ok(procesService.findAll());
    }
}
