package com.example.workorder.service;

import com.example.workorder.entity.Customer;
import com.example.workorder.repository.CustomerRepository;
import com.example.workorder.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService extends GenericService<Customer> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public GenericRepository<Customer> getRepository() {
        return repository;
    }
}
