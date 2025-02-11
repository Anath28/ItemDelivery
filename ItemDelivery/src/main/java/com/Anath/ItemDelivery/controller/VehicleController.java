package com.Anath.ItemDelivery.controller;

import com.Anath.ItemDelivery.entities.Item;
import com.Anath.ItemDelivery.entities.Vehicle;
import com.Anath.ItemDelivery.services.ItemService;
import com.Anath.ItemDelivery.services.VehicleService;
import com.Anath.ItemDelivery.services.VehicleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleServiceImp vehicleServiceImp;

    @Autowired
    private ItemService itemService;

    @PostMapping("/create-vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("/create-item")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping("/get-vehicle/{plateNumber}")
    ResponseEntity<Vehicle> getVehicleByPlateNumber(@PathVariable String plateNumber) {
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("add-item-to-vehicle/{plateNumber}/item/{itemId}")
    ResponseEntity<?> addItemToVehicle(@PathVariable String plateNumber, @PathVariable Long itemId) {
        Item item = itemService.getItemById(itemId);
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        List<Item> items = vehicle.getItems();
        float weightOnVehicle = 0;

        for (Item listItem : items) {
            weightOnVehicle += listItem.getWeight();
        }

        if ((weightOnVehicle + item.getWeight()) <= vehicle.getCarryingWeight()) {
            vehicle.getItems().add(item);
            vehicleService.createVehicle(vehicle);
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.badRequest().body("Too much weight for this vehicle");
        }
    }

//    @GetMapping("/vehicle-form")
//public String getVehicleForm(Model model) {
//    List<Vehicle> allVehicles = vehicleService.getAllVehicles();
//
//
//    for (Vehicle vehicle : allVehicles) {
//        float totalWeight = vehicle.getCarryingWeight();  // or calculate this elsewhere
//        vehicle.setTotalWeight(totalWeight);  // If you want to set it as a property
//    }
//    model.addAttribute("allVehicles", allVehicles);
//    model.addAttribute("vehicle", new Vehicle());
//    return "vehicle-form";
//}

}