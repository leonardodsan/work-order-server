package com.example.workorder.service;

import com.example.workorder.entity.GenericEntity;
import com.example.workorder.repository.GenericRepository;
import javassist.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public abstract class GenericService<T extends GenericEntity> {

    public abstract GenericRepository<T> getRepository();

    public Sort getDefaultSort() {
        return Sort.by(Sort.Order.asc("createdAt"),
                Sort.Order.desc("updatedAt"));
    }

    @Transactional(readOnly = true)
    public Optional<T> findOne(UUID id) {
        return getRepository().findById(id);
    }


    @Transactional(readOnly = true)
    public List<T> findAll(Sort sort) {
        return (List<T>) getRepository().findAll(sort);
    }

    @Transactional(readOnly = true)
    public T findById(UUID id) throws NotFoundException {
        Optional<T> entity = getRepository().findById(id);
        return entity.orElseThrow(() -> new NotFoundException("Entity not found"));
    }

    public T beforeCreate(T entity) {
        entity.setCreatedAt(Date.from(ZonedDateTime.now().toInstant()));
        entity.setCreatedAt(Date.from(ZonedDateTime.now().toInstant()));
        return entity;
    }

    public T beforeUpdate(T entity) throws NotFoundException {
        entity.setUpdatedAt(Date.from(ZonedDateTime.now().toInstant()));
        return entity;
    }

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public void delete(UUID id) throws NotFoundException {
        this.delete(get(id));
    }

    public void delete(T entity) throws NotFoundException {
        getRepository().delete(entity);
    }

    public T get(UUID id) throws NotFoundException {
        return getRepository().findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
    }
}
