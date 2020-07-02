package main;

import entities.Product;

import javax.persistence.Persistence;

/*
By default
1st level cache = context
 */
public class Example4 {

    public static void main(String[] args) {

        var entityManagerFactory =
                Persistence.createEntityManagerFactory("my-persistence-unit");

        var em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();

        var product = em.find(Product.class, 1); // goes to L2 cache

        // CACHE
        var cache = entityManagerFactory.getCache();
        System.out.println(cache.contains(Product.class, 1));

        em.getTransaction().commit(); // UPDATE
        em.close();
    }

}
