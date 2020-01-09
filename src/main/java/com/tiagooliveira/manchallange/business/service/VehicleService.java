package com.tiagooliveira.manchallange.business.service;

import com.tiagooliveira.manchallange.data.entity.Vehicle;
import com.tiagooliveira.manchallange.data.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicleByLicense(String license){
        Iterable<Vehicle> vehicles = this.vehicleRepository.findAll();
        List<Vehicle> result = new ArrayList<>();
        vehicles.forEach(result::add);
        return result;
    }
}
