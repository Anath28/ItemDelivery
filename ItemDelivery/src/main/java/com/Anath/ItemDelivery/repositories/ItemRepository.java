package com.Anath.ItemDelivery.repositories;

import com.Anath.ItemDelivery.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
