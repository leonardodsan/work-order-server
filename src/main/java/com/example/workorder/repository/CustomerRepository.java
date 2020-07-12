package com.example.workorder.repository;

import com.example.workorder.entity.Customer;
import com.example.workorder.entity.Device;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends GenericRepository<Customer>{}
