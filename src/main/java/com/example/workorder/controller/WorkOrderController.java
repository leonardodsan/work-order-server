package com.example.workorder.controller;

import com.example.workorder.entity.WorkOrder;
import com.example.workorder.service.GenericService;
import com.example.workorder.service.ProfessionalService;
import com.example.workorder.service.WorkOrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/work-order")
public class WorkOrderController extends CrudController<WorkOrder> {

    @Autowired
    private WorkOrderService service;

    @Autowired
    private ProfessionalService professionalService;

    @Override
    public GenericService<WorkOrder> getService() {
        return service;
    }

    @GetMapping("/byAccountable/{id}")
    public ResponseEntity findCustomSearch(@PathVariable String id) throws NotFoundException {
        Set orders = service.findByAccountable(professionalService.get(UUID.fromString(id)));
        return ResponseEntity.ok(orders);
    }
}
