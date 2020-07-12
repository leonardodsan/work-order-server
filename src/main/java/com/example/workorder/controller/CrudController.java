
package com.example.workorder.controller;

import com.example.workorder.entity.GenericEntity;
import com.example.workorder.service.GenericService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public abstract class CrudController<T extends GenericEntity> {

    public abstract GenericService<T> getService();

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        List<T> all = getService().findAll(getService().getDefaultSort());
        return ResponseEntity.ok(all);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable String id) throws NotFoundException {
        T entity = getService().findById(UUID.fromString(id));
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity save(@Valid @RequestBody T t) {
        T save = getService().save(getService().beforeCreate(t));
        return ResponseEntity.ok(save);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity update(@Valid @RequestBody T t) throws NotFoundException {
        T save = getService().save(getService().beforeUpdate(t));
        return ResponseEntity.ok().body(save);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) throws NotFoundException {
        getService().delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}
