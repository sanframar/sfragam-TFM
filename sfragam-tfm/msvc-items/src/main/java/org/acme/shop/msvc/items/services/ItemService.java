package org.acme.shop.msvc.items.services;

import org.acme.shop.msvc.items.models.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> findAll();
    Optional<Item> byId(Long id);
    Item save(Item item);
    void delete(Long id);
}
