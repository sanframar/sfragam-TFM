package org.acme.shop.msvc.items.services;

import org.acme.shop.msvc.items.models.entity.Item;
import org.acme.shop.msvc.items.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Item> byId(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
