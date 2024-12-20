package com.example.process_permis_conduite.service;

import com.example.process_permis_conduite.dto.CitoyenDTO;
import com.example.process_permis_conduite.entities.Citoyen;
import com.example.process_permis_conduite.repository.CitoyenRepository;
import com.example.process_permis_conduite.uses.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitoyenService implements BaseService<CitoyenDTO, String> {
    @Autowired
    private CitoyenRepository citoyenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CitoyenDTO save(CitoyenDTO dto) {
        Citoyen citoyen = modelMapper.map(dto, Citoyen.class);
        citoyen = citoyenRepository.save(citoyen);
        return modelMapper.map(citoyen, CitoyenDTO.class);
    }

    @Override
    public CitoyenDTO update(String id, CitoyenDTO dto) {
        Citoyen citoyen = citoyenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Citoyen not found"));
        modelMapper.map(dto, citoyen);
        citoyen = citoyenRepository.save(citoyen);
        return modelMapper.map(citoyen, CitoyenDTO.class);
    }

    @Override
    public void delete(String id) {
        citoyenRepository.deleteById(id);
    }

    @Override
    public CitoyenDTO findById(String id) {
        Citoyen citoyen = citoyenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Citoyen not found"));
        return modelMapper.map(citoyen, CitoyenDTO.class);
    }

    @Override
    public List<CitoyenDTO> findAll() {
        return citoyenRepository.findAll().stream()
                .map(c -> modelMapper.map(c, CitoyenDTO.class))
                .collect(Collectors.toList());
    }
}
