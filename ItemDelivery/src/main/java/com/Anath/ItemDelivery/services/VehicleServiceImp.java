package com.Anath.ItemDelivery.services;

import com.Anath.ItemDelivery.Vehicle;
import com.Anath.ItemDelivery.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImp implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll(vehicle);
    }

    @Override
    public Vehicle getVehicleByPlateNumber(String status) {
        return null;
    }
}
