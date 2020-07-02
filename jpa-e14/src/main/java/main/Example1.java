package main;

import entities.Product;

import javax.persistence.Persistence;

public class Example1 {

    public static void main(String[] args) {

        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");

        var em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        var product = new Product();
        product.setName("Product 1");
        em.persist(product);

        em.getTransaction().commit();
        em.close();
    }

}
