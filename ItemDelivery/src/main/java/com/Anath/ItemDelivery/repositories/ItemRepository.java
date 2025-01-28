package com.Anath.ItemDelivery.repositories;

import com.Anath.ItemDelivery.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

}
