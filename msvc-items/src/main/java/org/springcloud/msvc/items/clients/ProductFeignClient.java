package org.springcloud.msvc.items.clients;

import org.springcloud.msvc.items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-products")
public interface ProductFeignClient {

    @GetMapping("api/v1/products")
    List<Product> findAll();

    @GetMapping("api/v1/products/{id}")
    Product findById(@PathVariable Long id);

}