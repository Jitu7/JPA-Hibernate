package com.jyotirmayadas.main;

import com.jyotirmayadas.entities.Product;

import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        var product = entityManager.find(Product.class, 3);

       /* var company = new Company();
        company.setName("ABC");
        company.setStreet("Street 1");
        company.setNumber("A1");
        company.setDetails("DETAILS");

        entityManager.persist(company);*/

//        var product = new Product();
//        product.setName("Beer");
//        product.setPrice(5);
//        entityManager.persist(product);

//        var detail = new Detail();
//        detail.setKcal(100);
//
//        detail.setProduct(product);
//        product.setDetail(detail);
//
//        entityManager.persist(detail);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
