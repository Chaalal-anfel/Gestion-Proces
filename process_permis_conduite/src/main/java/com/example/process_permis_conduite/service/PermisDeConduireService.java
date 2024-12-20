package com.example.process_permis_conduite.service;
import com.example.process_permis_conduite.dto.PermisDeConduireDTO;
import com.example.process_permis_conduite.entities.PermisDeConduire;
import com.example.process_permis_conduite.repository.CitoyenRepository;
import com.example.process_permis_conduite.repository.PermisDeConduireRepository;
import com.example.process_permis_conduite.uses.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermisDeConduireService implements BaseService<PermisDeConduireDTO, String> {
    @Autowired
    private PermisDeConduireRepository permisDeConduireRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PermisDeConduireDTO save(PermisDeConduireDTO dto) {
        PermisDeConduire permis = modelMapper.map(dto, PermisDeConduire.class);
        permis = permisDeConduireRepository.save(permis);
        return modelMapper.map(permis, PermisDeConduireDTO.class);
    }

    @Override
    public PermisDeConduireDTO update(String id, PermisDeConduireDTO dto) {
        PermisDeConduire permis = permisDeConduireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permis not found"));
        modelMapper.map(dto, permis);
        permis = permisDeConduireRepository.save(permis);
        return modelMapper.map(permis, PermisDeConduireDTO.class);
    }

    @Override
    public void delete(String id) {
        permisDeConduireRepository.deleteById(id);
    }

    @Override
    public PermisDeConduireDTO findById(String id) {
        PermisDeConduire permis = permisDeConduireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permis not found"));
        return modelMapper.map(permis, PermisDeConduireDTO.class);
    }

    @Override
    public List<PermisDeConduireDTO> findAll() {
        return permisDeConduireRepository.findAll().stream()
                .map(p -> modelMapper.map(p, PermisDeConduireDTO.class))
                .collect(Collectors.toList());
    }
}
