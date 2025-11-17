package org.springcloud.msvc.items.services;

import org.springcloud.msvc.items.models.Item;

import java.util.List;
import java.util.Optional;

public class ItemService {

    List<Item> findAll();
    Optional<Item> findById(Long id);

}
