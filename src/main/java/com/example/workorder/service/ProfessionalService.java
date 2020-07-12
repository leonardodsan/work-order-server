package com.example.workorder.service;

import com.example.workorder.entity.Professional;
import com.example.workorder.repository.GenericRepository;
import com.example.workorder.repository.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService extends GenericService<Professional> {

    @Autowired
    private ProfessionalRepository repository;

    @Override
    public GenericRepository<Professional> getRepository() {
        return repository;
    }
}
