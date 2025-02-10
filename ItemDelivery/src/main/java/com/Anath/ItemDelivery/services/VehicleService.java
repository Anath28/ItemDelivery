package com.Anath.ItemDelivery.services;

import com.Anath.ItemDelivery.entities.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleByPlateNumber(String plateNumber);
    void deleteVehicle(Long id);
}
