package com.example.workorder.repository;

import com.example.workorder.entity.Professional;
import com.example.workorder.entity.WorkOrder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProfessionalRepository extends GenericRepository<Professional>{

}
