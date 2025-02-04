package com.Anath.ItemDelivery.controller;

import ch.qos.logback.core.model.Model;
import com.Anath.ItemDelivery.Vehicle;
import com.Anath.ItemDelivery.services.ItemService;
import com.Anath.ItemDelivery.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static sun.security.x509.OIDMap.addAttribute;

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
    public String createVehicle(Model model) {
        Vehicle vehicle = new Vehicle();
        model.addAttribute(attributeName:"vehicle", vehicle)
        .addAttribute(attributeName:)
    }
}
