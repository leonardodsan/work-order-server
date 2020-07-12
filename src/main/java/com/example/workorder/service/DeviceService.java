package com.example.workorder.service;

import com.example.workorder.entity.Device;
import com.example.workorder.repository.DeviceRepository;
import com.example.workorder.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeviceService extends GenericService<Device> {

    @Autowired
    private DeviceRepository repository;

    @Override
    public GenericRepository<Device> getRepository() {
        return repository;
    }
}
