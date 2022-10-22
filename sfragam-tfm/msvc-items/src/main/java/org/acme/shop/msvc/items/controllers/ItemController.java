package org.acme.shop.msvc.items.controllers;


import feign.Response;
import org.acme.shop.msvc.items.models.entity.Item;
import org.acme.shop.msvc.items.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> list(){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id){
        Optional<Item> item = itemService.byId(id);
        if(item.isPresent()){
            return ResponseEntity.ok(item.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Item item){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Item item, @PathVariable Long id){
        Optional<Item> o = itemService.byId(id);
        if(o.isPresent()){
            Item itemDb = o.get();
            itemDb.setName(item.getName());
            itemDb.setAmount(item.getAmount());
            return ResponseEntity.status(HttpStatus.CREATED).body(itemService.save(itemDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Item> o = itemService.byId(id);
        if(o.isPresent()){
            itemService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
