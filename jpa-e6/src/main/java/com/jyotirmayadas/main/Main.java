package com.jyotirmayadas.main;

import com.jyotirmayadas.entities.Document;
import com.jyotirmayadas.entities.Person;

import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        /*var employee = new Employee();
        employee.setName("EMP 1");

        var department = new Department();
        department.setName("DEP 1");
        department.setEmployee(new ArrayList<>());
        department.getEmployee().add(employee);

        entityManager.persist(employee);
        entityManager.persist(department);*/

        var person = new Person();
        person.setName("ABC");
        person.setDocuments(new ArrayList<>());

        var document = new Document();
        document.setName("DOC 1");

        document.setPerson(person);
        person.getDocuments().add(document);

//        entityManager.persist(person);
        entityManager.persist(document);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
