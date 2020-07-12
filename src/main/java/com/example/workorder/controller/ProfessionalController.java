package com.example.workorder.controller;

import com.example.workorder.service.GenericService;
import com.example.workorder.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professional")
public class ProfessionalController extends CrudController<com.example.workorder.entity.Professional> {

    @Autowired
    private ProfessionalService service;

    @Override
    public GenericService<com.example.workorder.entity.Professional> getService() {
        return service;
    }
}
