package com.example.workorder.repository;

import com.example.workorder.entity.Device;
import com.example.workorder.entity.Professional;
import com.example.workorder.entity.WorkOrder;
import com.example.workorder.entity.WorkOrderOcurrence;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WorkOrderOcurrenceRepository extends GenericRepository<WorkOrderOcurrence>{

    Set<WorkOrderOcurrence> findByWorkOrder(WorkOrder workOrder, Sort sort);

}
