package com.tiagooliveira.manchallange.controllers;
import com.tiagooliveira.manchallange.data.entity.Vehicle;
import com.tiagooliveira.manchallange.data.repository.VehicleRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class VehicleController {

    private final VehicleRepository repository;

    VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/vehicles")
    List<Vehicle> allVehicle() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/vehicles/{license}")
    List<Vehicle> vehicleByLicense(@PathVariable String license) {
        return repository.findByLicense(license);
    }
}
