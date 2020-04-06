package com.jyotirmayadas.main;

import com.jyotirmayadas.main.entities.*;
import com.jyotirmayadas.main.entities.embeddables.Address;
import com.jyotirmayadas.main.entities.enums.Currency;

import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager = entityManagerFactory.createEntityManager();

        var price = new Price();
        price.setAmount(100);
        price.setCurrency(Currency.EUR);

        var product = new Product();
        product.setExpirationDate(LocalDate.now());

        var event = new Event();
        event.setEventTime(LocalDateTime.now());

        var employee = new Employee();
        employee.setEmpDate(new Date());

        var company = new Company();
        company.setName("ABC");
        company.setAddress(new Address());

        company.getAddress().setNumber("4");
        company.getAddress().setCity("London");
        company.getAddress().setStreet("Some Street");

        try {

            entityManager.getTransaction().begin();

            entityManager.persist(price);
            entityManager.persist(product);
            entityManager.persist(event);
            entityManager.persist(employee);
            entityManager.persist(company);

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
