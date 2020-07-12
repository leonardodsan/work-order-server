package com.example.workorder.service;

import com.example.workorder.entity.Professional;
import com.example.workorder.entity.WorkOrder;
import com.example.workorder.entity.WorkOrderOcurrence;
import com.example.workorder.repository.GenericRepository;
import com.example.workorder.repository.WorkOrderOcurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class WorkOrderOcurrenceService extends GenericService<WorkOrderOcurrence> {

    @Autowired
    private WorkOrderOcurrenceRepository repository;

    @Override
    public GenericRepository<WorkOrderOcurrence> getRepository() {
        return repository;
    }

    public Set<WorkOrderOcurrence> findByOrder(WorkOrder order) {
        return repository.findByWorkOrder(order, getDefaultSort());
    }
}
