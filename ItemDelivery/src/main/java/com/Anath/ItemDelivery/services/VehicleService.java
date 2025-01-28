package com.Anath.ItemDelivery.services;

import com.Anath.ItemDelivery.Vehicle;

import java.util.List;

public interface VehicleService {

    static Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleByPlateNumber(String status);
}
