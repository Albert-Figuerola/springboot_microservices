package com.springcloud.msvc.products.controllers;

import com.springcloud.msvc.products.entities.Product;
import com.springcloud.msvc.products.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class ProductController {

    final private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("products")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @GetMapping("products/{id}")
    public ResponseEntity<?> findById(
            @PathVariable Long id
    ) {
        Optional<Product> product = this.service.findById(id);

        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
