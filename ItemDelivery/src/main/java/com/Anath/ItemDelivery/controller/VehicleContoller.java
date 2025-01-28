package com.Anath.ItemDelivery.controller;

import com.Anath.ItemDelivery.Vehicle;
import com.Anath.ItemDelivery.services.ItemService;
import com.Anath.ItemDelivery.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class VehicleContoller {

    private final ItemService itemService;
    private final VehicleService vehicleService;

    public VehicleContoller(ItemService itemService, VehicleService vehicleService){
        this.itemService = itemService;
        this.vehicleService = vehicleService;
    }
    @PostMapping("/create-vehicle")
    ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        VehicleService.createVehicle(vehicle);

        return ResponseEntity.ok(vehicle);
    }


}