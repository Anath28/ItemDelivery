package com.Anath.ItemDelivery.services;

import com.Anath.ItemDelivery.Item;

public interface ItemService {
    Item createItem(Item item);
    Item getItem(long id);
    Iterable<Item> getAllItems();
    void deleteItem(long id);
}
