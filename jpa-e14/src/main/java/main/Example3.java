package main;

import entities.Product;

import javax.persistence.Persistence;

public class Example3 {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");

        var em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        var product = em.find(Product.class, 1); // post load
        em.remove(product); // pre remove and post remove

        em.getTransaction().commit(); // UPDATE
        em.close();
    }

}
