package com.Anath.ItemDelivery.services;

import com.Anath.ItemDelivery.entities.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    Item getItemById(long id);
    List<Item> getAllItems();
    void deleteItem(long id);
}
