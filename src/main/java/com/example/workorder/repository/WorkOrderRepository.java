package com.example.workorder.repository;

import com.example.workorder.entity.Device;
import com.example.workorder.entity.Professional;
import com.example.workorder.entity.WorkOrder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WorkOrderRepository extends GenericRepository<WorkOrder>{

    Set<WorkOrder> findByAccountable(Professional professional, Sort sort);

}
