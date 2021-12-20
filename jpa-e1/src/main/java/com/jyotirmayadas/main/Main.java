package com.jyotirmayadas.main;

import com.jyotirmayadas.entities.Product;

import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // EntityManagerFactory
        // EntityManager --> manages a context in which u might hv instances of entities. It's STATELESS.
                            // Recommended to use multiple entityManagers, for each of the use cases.

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager1 = emf.createEntityManager();

        Product product1 = new Product();
        product1.setId(101);
        product1.setName("Beer");
        product1.setPrice(10.4);
        product1.setExpirationDate(LocalDate.now());

        try {
            entityManager1.getTransaction().begin();

            entityManager1.persist(product1); // adding the instance in the context

            entityManager1.getTransaction().commit();

        } catch (Exception ex) {
           entityManager1.getTransaction().rollback();

        } finally {
            entityManager1.close();
        }

        var entityManager2 = emf.createEntityManager();

        Product product2 = new Product();
        product2.setId(102);
        product2.setName("Beer");
        product2.setPrice(10.4);
        product2.setExpirationDate(LocalDate.now());

        try {
            entityManager2.getTransaction().begin();

            entityManager2.persist(product2); // adding the instance in the context

            entityManager2.getTransaction().commit();

        } catch (Exception ex) {
            entityManager2.getTransaction().rollback();

        } finally {
            entityManager2.close();
        }
    }
}
