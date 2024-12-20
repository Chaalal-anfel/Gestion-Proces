package com.example.process_permis_conduite.controller;


import com.example.process_permis_conduite.dto.PermisDeConduireDTO;
import com.example.process_permis_conduite.entities.Citoyen;
import com.example.process_permis_conduite.entities.PermisDeConduire;
import com.example.process_permis_conduite.service.CitoyenService;
import com.example.process_permis_conduite.service.PermisDeConduireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/permis")
public class PermisDeConduireController {
    @Autowired
    private PermisDeConduireService permisDeConduireService;

    @PostMapping
    public ResponseEntity<PermisDeConduireDTO> create(@RequestBody PermisDeConduireDTO dto) {
        return ResponseEntity.ok(permisDeConduireService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermisDeConduireDTO> update(@PathVariable String id, @RequestBody PermisDeConduireDTO dto) {
        return ResponseEntity.ok(permisDeConduireService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        permisDeConduireService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisDeConduireDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(permisDeConduireService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PermisDeConduireDTO>> getAll() {
        return ResponseEntity.ok(permisDeConduireService.findAll());
    }
}
