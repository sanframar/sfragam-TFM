package org.acme.shop.msvc.items.repositories;

import org.acme.shop.msvc.items.models.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
