package com.example.process_permis_conduite.service;

// Service pour Vehicule
import com.example.process_permis_conduite.dto.VehiculeDTO;
import com.example.process_permis_conduite.entities.Vehicule;
import com.example.process_permis_conduite.repository.VehiculeRepository;
import com.example.process_permis_conduite.uses.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehiculeService implements BaseService<VehiculeDTO, String> {
    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public VehiculeDTO save(VehiculeDTO dto) {
        Vehicule vehicule = modelMapper.map(dto, Vehicule.class);
        vehicule = vehiculeRepository.save(vehicule);
        return modelMapper.map(vehicule, VehiculeDTO.class);
    }

    @Override
    public VehiculeDTO update(String id, VehiculeDTO dto) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule not found"));
        modelMapper.map(dto, vehicule);
        vehicule = vehiculeRepository.save(vehicule);
        return modelMapper.map(vehicule, VehiculeDTO.class);
    }

    @Override
    public void delete(String id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public VehiculeDTO findById(String id) {
        Vehicule vehicule = vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule not found"));
        return modelMapper.map(vehicule, VehiculeDTO.class);
    }

    @Override
    public List<VehiculeDTO> findAll() {
        return vehiculeRepository.findAll().stream()
                .map(v -> modelMapper.map(v, VehiculeDTO.class))
                .collect(Collectors.toList());
    }
}
