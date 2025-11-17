package org.springcloud.msvc.items.clients;

import org.springcloud.msvc.items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "localhost:8001")
public interface ProductFeignClient {

    @GetMapping("products")
    List<Product> findAll();

    @GetMapping("products/{id}")
    Product findById(@PathVariable Long id);

}