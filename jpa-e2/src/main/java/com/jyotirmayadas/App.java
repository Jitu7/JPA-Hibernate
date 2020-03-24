package com.jyotirmayadas;

import com.jyotirmayadas.entities.Event;
import com.jyotirmayadas.entities.Product;

import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        var entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var entityManager = entityManagerFactory.createEntityManager();

        var product = new Product();
        product.setName("Beer");

        var event = new Event();
        event.setDescription("ABCD");

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(product);
            entityManager.persist(event);

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
