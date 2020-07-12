package com.example.workorder.controller;

import com.example.workorder.entity.WorkOrderOcurrence;
import com.example.workorder.service.GenericService;
import com.example.workorder.service.WorkOrderOcurrenceService;
import com.example.workorder.service.WorkOrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/work-order-ocurrence")
public class WorkOrderOcurrenceController extends CrudController<WorkOrderOcurrence> {

    @Autowired
    private WorkOrderOcurrenceService service;

    @Autowired
    private WorkOrderService serviceOrder;

    @Override
    public GenericService<WorkOrderOcurrence> getService() {
        return service;
    }

    @GetMapping("/byOrder/{id}")
    public ResponseEntity findCustomSearch(@PathVariable String id) throws NotFoundException {
        Set ocurrences = service.findByOrder(serviceOrder.get(UUID.fromString(id)));
        return ResponseEntity.ok(ocurrences);
    }
}
