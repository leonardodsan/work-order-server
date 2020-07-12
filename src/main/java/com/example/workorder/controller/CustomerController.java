package com.example.workorder.controller;

import com.example.workorder.entity.Customer;
import com.example.workorder.service.GenericService;
import com.example.workorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController extends CrudController<Customer> {

    @Autowired
    private CustomerService service;

    @Override
    public GenericService<Customer> getService() {
        return service;
    }
}
