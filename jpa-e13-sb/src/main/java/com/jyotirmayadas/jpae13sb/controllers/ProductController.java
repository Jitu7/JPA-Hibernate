package com.jyotirmayadas.jpae13sb.controllers;

import com.jyotirmayadas.jpae13sb.entities.Product;
import com.jyotirmayadas.jpae13sb.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add/{name}")
    public void addProduct(@PathVariable("name") String name) {
        productService.addProduct(name);
    }

    @GetMapping("/get")
    public List<Product> findProducts() {
        return productService.findProducts();
    }
}
