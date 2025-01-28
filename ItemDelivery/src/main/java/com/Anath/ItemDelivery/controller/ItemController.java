package com.Anath.ItemDelivery.controller;

import com.Anath.ItemDelivery.Item;
import com.Anath.ItemDelivery.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item")

public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("create-item")
    ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return ResponseEntity.ok(newItem);
    }
}
