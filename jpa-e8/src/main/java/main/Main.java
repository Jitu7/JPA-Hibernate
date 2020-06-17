package main;

import entites.*;

import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

//        var department = new Department();
//        department.setName("Dep 1");
//
//        var departmentDetails = new DepartmentDetails();
//        departmentDetails.setContractNo("ABC123");
//        departmentDetails.setDepartment(department);
//
//        var employee = new Employee();
//        employee.setName("Employee 1");
//        employee.setDepartmentDetails(departmentDetails);
//
//        entityManager.persist(department);
//        entityManager.persist(employee);

//        var professor = new Professor();
//        professor.setName("Professor 1");
//
//        var professorDetails = new ProfessorDetails();
//        professorDetails.setProfessors(Stream.of(professor)
//                .collect(Collectors.toSet()));
//
//        var student = new Student();
//        student.setName("Student 1");
//        student.setProfessorDetails(professorDetails);
//
//        entityManager.persist(professor);
//        entityManager.persist(student);

        var document = new Document();
        document.setReference("ABC");
        document.setNumber("12345");

        var person = new Person();
        person.setName("Person 1");
        person.setPhoneNumbers(List.of("123", "2334", "333"));
        person.setDocuments(List.of(document));

        entityManager.persist(person);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
