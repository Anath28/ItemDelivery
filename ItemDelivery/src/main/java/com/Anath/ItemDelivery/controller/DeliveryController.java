package com.Anath.ItemDelivery.controller;

import org.springframework.ui.Model;
import com.Anath.ItemDelivery.Vehicle;
import com.Anath.ItemDelivery.services.ItemService;
import com.Anath.ItemDelivery.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeliveryController {
    private final VehicleService vehicleService;
    private final ItemService itemService;

    public DeliveryController(VehicleService vehicleService, ItemService itemService, ItemService itemService1) {
        this.vehicleService = vehicleService;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
    @GetMapping("/create-vehicle")
    public String createVehicle(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle)
                .addAttribute("allVehicles", vehicleService.getAllVehicles());
        return "feature";
    }
    @PostMapping("/post-vehicle")
    public String postVehicle(Model model, @ModelAttribute("vehicle") Vehicle vehicle){
        String message = "vehicle created successful";
        vehicleService.createVehicle(vehicle);
        model.addAttribute("message", message);
        return "feature";
    }
}
