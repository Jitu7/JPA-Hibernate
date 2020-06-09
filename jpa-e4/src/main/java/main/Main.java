package main;

import entities.Building;
import entities.Person;
import entities.embeddables.BuildingPK;

import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        var entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        var entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

//        Company company = new Company();
//        company.setName("C1");
//        company.setAddress(new Address());
//
//        company.getAddress().setNo("5");
//        company.getAddress().setCity("My City");
//        company.getAddress().setStr("Some Street");
//
//        entityManager.persist(company);

//        Department department = new Department();
//        department.setName("DEP 1");
//        department.setCode("ABC");
//        department.setNo(10);
//
//        entityManager.persist(department);

//        Building building = new Building();
//        building.setName("B1");
//        building.setBuildingPK(new BuildingPK());
//        building.getBuildingPK().setCode("ABC");
//        building.getBuildingPK().setNo(10);
//
//        entityManager.persist(building);

        Person p1 = new Person();
        p1.setName("P1");

        entityManager.persist(p1);

        entityManager.getTransaction().commit();
    }
}
