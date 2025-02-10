package com.Anath.ItemDelivery.services;

import com.Anath.ItemDelivery.entities.Item;
import com.Anath.ItemDelivery.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImp implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public void deleteItem(long id) {
        itemRepository.deleteById(id);

    }
}
