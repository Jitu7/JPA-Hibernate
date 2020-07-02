package com.jyotirmayadas.jpae13sb.services;

import com.jyotirmayadas.jpae13sb.entities.Product;
import com.jyotirmayadas.jpae13sb.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(String name) {
        Product p = new Product();
        p.setName(name);

        productRepository.save(p);
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }
}
