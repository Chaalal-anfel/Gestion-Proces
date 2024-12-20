package com.example.process_permis_conduite.service;

import com.example.process_permis_conduite.dto.ProcesDTO;
import com.example.process_permis_conduite.entities.Proces;
import com.example.process_permis_conduite.repository.ProcesRepository;
import com.example.process_permis_conduite.uses.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcesService implements BaseService<ProcesDTO, Long> {
    @Autowired
    private ProcesRepository procesRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProcesDTO save(ProcesDTO dto) {
        Proces proces = modelMapper.map(dto, Proces.class);
        proces = procesRepository.save(proces);
        return modelMapper.map(proces, ProcesDTO.class);
    }

    @Override
    public ProcesDTO update(Long id, ProcesDTO dto) {
        Proces proces = procesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proces not found"));
        modelMapper.map(dto, proces);
        proces = procesRepository.save(proces);
        return modelMapper.map(proces, ProcesDTO.class);
    }

    @Override
    public void delete(Long id) {
        procesRepository.deleteById(id);
    }

    @Override
    public ProcesDTO findById(Long id) {
        Proces proces = procesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Proces not found"));
        return modelMapper.map(proces, ProcesDTO.class);
    }

    @Override
    public List<ProcesDTO> findAll() {
        return procesRepository.findAll().stream()
                .map(p -> modelMapper.map(p, ProcesDTO.class))
                .collect(Collectors.toList());
    }
}
