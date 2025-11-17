package org.springcloud.msvc.items.services;

import feign.FeignException;
import org.springcloud.msvc.items.clients.ProductFeignClient;
import org.springcloud.msvc.items.models.Item;
import org.springcloud.msvc.items.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductFeignClient client;
    Random random = new Random();

    @Override
    public List<Item> findAll() {

        return client.findAll()
                .stream()
                .map(product ->
                        new Item(product, random.nextInt(10) + 1)
                ).toList();
    }

    @Override
    public Optional<Item> findById(Long id) {
        try {
            Product product = client.findById(id);

            return Optional.of(new Item(product, random.nextInt(10) + 1));
        } catch (FeignException e) {
            return Optional.empty();
        }
    }

}
