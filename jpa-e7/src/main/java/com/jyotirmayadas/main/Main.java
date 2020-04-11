package com.jyotirmayadas.main;

import com.jyotirmayadas.entities.Professor;
import com.jyotirmayadas.entities.Student;

import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        var professor = new Professor();
        professor.setName("Prof 1");

        var student = new Student();
        student.setName("Stud 1");

        professor.setStudents(new ArrayList<>());
        professor.getStudents().add(student);

        student.setProfessors(new ArrayList<>());
        student.getProfessors().add(professor);

//        entityManager.persist(student);
        entityManager.persist(professor);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
