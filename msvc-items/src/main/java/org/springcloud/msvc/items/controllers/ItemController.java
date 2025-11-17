package org.springcloud.msvc.items.controllers;

import org.springcloud.msvc.items.models.Item;
import org.springcloud.msvc.items.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("items")
    public List<Item> list() {
        return service.findAll();
    }

    @GetMapping("items/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Item> item = service.findById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.status(404).body(Collections.singletonMap("message", "Product not found"));
        }
    }

}
