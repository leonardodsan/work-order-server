package com.example.workorder.controller;

import com.example.workorder.entity.Device;
import com.example.workorder.service.GenericService;
import com.example.workorder.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController extends CrudController<Device> {

    @Autowired
    private DeviceService service;

    @Override
    public GenericService<Device> getService() {
        return service;
    }
}
