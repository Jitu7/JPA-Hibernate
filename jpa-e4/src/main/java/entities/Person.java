package entities;

import javax.persistence.*;

/*
    if we put the annotation both on the field as well as on the property,
    then we have to set explicitly which one to use.
    @Access(AccType.FIELD)
    @Access(AccType.PROPERTY)
 */
@Entity(name = "Person")
@Table(name = "person")
//@Access(AccessType.FIELD)
public class Person {

    /*
        Access through field
     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // FIELD ACCESS

    private String name;

    /*
        Access through property
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() { // PROPERTY ACCESS
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
