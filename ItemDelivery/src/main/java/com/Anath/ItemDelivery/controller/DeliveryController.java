package com.Anath.ItemDelivery.controller;

import com.Anath.ItemDelivery.entities.Item;
import org.springframework.ui.Model;
import com.Anath.ItemDelivery.entities.Vehicle;
import com.Anath.ItemDelivery.services.ItemService;
import com.Anath.ItemDelivery.services.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    @GetMapping("/create-item")
    public String createItem(Model model){
        Item item = new Item();
        model.addAttribute("item", item)
                .addAttribute("allItems", itemService.getAllItems());
        return "item";
    }

    @PostMapping("/post-item")
    public String postItem(Model model, @ModelAttribute("item") Item item){
        String message = "Item created successfully";
        itemService.createItem(item);
        model.addAttribute("message", message);
        return "item";
    }
     @PostMapping("/add-item-to-vehicle")
    public String postItem(Model model, @RequestParam Long itemId, @RequestParam String plateNumber) {
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        Item item = itemService.getItemById(itemId);

        if (vehicle == null) {
            model.addAttribute("message", "Vehicle not found");
            model.addAttribute("allVehicles", vehicleService.getAllVehicles());
            model.addAttribute("allItems", itemService.getAllItems());
            return "feature";
        }

        if (item == null) {
            model.addAttribute("message", "Item not found");
            model.addAttribute("allVehicles", vehicleService.getAllVehicles());
            model.addAttribute("allItems", itemService.getAllItems());
            return "feature";
        }

        List<Item> items = vehicle.getItems();
        float weightOnVehicle = items.stream().map(Item::getWeight).reduce(0f, Float::sum);

        if ((weightOnVehicle + item.getWeight()) <= vehicle.getCarryingWeight()) {
            vehicle.getItems().add(item);
            vehicleService.createVehicle(vehicle);
            model.addAttribute("message", "Item added to vehicle successfully");
        } else {
            model.addAttribute("message", "Too much weight for this vehicle");
        }

        model.addAttribute("allVehicles", vehicleService.getAllVehicles());
        model.addAttribute("allItems", itemService.getAllItems());

        return "feature";
    }

}
