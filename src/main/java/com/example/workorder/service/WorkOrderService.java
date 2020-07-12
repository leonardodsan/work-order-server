package com.example.workorder.service;

import com.example.workorder.entity.Professional;
import com.example.workorder.entity.WorkOrder;
import com.example.workorder.repository.GenericRepository;
import com.example.workorder.repository.WorkOrderRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Set;

@Service
public class WorkOrderService extends GenericService<WorkOrder> {

    @Autowired
    private WorkOrderRepository repository;

    @Override
    public GenericRepository<WorkOrder> getRepository() {
        return repository;
    }

    public Set<WorkOrder> findByAccountable(Professional accountable) {
        return repository.findByAccountable(accountable, getDefaultSort());
    }

    @Override
    public WorkOrder beforeUpdate(WorkOrder entity) throws NotFoundException {
        WorkOrder workOrderSaved = get(entity.getId());
        if(WorkOrder.Status.PROGRESS.equals(entity.getStatus()) && workOrderSaved.getStartMoment() == null) {
            entity.setStartMoment(Date.from(ZonedDateTime.now().toInstant()));
        } else {
            entity.setStartMoment(workOrderSaved.getStartMoment());
        }
        if (WorkOrder.Status.FINISHED.equals(entity.getStatus()) && workOrderSaved.getStartMoment() == null) {
            entity.setEndMoment(Date.from(ZonedDateTime.now().toInstant()));
        } else {
            entity.setEndMoment(workOrderSaved.getEndMoment());
        }

        return super.beforeUpdate(entity);
    }
}
