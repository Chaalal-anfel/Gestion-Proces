package com.example.process_permis_conduite.controller;

// Controller pour Vehicule
import com.example.process_permis_conduite.dto.VehiculeDTO;
import com.example.process_permis_conduite.entities.Vehicule;
import com.example.process_permis_conduite.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/vehicules")
public class VehiculeController {
    @Autowired
    private VehiculeService vehiculeService;

    @PostMapping
    public ResponseEntity<VehiculeDTO> create(@RequestBody VehiculeDTO dto) {
        return ResponseEntity.ok(vehiculeService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculeDTO> update(@PathVariable String id, @RequestBody VehiculeDTO dto) {
        return ResponseEntity.ok(vehiculeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        vehiculeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculeDTO> getById(@PathVariable String id) {
        return ResponseEntity.ok(vehiculeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<VehiculeDTO>> getAll() {
        return ResponseEntity.ok(vehiculeService.findAll());
    }
}
