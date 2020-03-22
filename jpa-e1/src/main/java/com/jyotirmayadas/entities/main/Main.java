package com.jyotirmayadas.entities.main;

import com.jyotirmayadas.entities.Product;

import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // EntityManagerFactory
        // EntityManager

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = emf.createEntityManager();

        Product product = new Product();
        product.setId(100);
        product.setName("Beer");
        product.setPrice(10.4);
        product.setExpirationDate(LocalDate.now());

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(product); // adding the instance in the context

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
           entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }
}
