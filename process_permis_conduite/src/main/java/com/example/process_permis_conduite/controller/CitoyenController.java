package com.example.process_permis_conduite.controller;

import com.example.process_permis_conduite.dto.CitoyenDTO;
import com.example.process_permis_conduite.entities.Citoyen;
import com.example.process_permis_conduite.service.CitoyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.Optional;
@RestController
@RequestMapping("api/citoyens")
public class CitoyenController {
    @Autowired
    private CitoyenService citoyenService;

    @PostMapping
    public ResponseEntity<CitoyenDTO> create(@RequestBody CitoyenDTO dto) {
        return ResponseEntity.ok(citoyenService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitoyenDTO> update(@PathVariable String id, @RequestBody CitoyenDTO dto) {
        return ResponseEntity.ok(citoyenService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        citoyenService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitoyenDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(citoyenService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CitoyenDTO>> getAll() {
        return ResponseEntity.ok(citoyenService.findAll());
    }
}
