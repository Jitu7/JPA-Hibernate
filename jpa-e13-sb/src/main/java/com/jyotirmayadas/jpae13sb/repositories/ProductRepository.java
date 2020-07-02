package com.jyotirmayadas.jpae13sb.repositories;

import com.jyotirmayadas.jpae13sb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    List<Product> findProductByName(String name);
}
