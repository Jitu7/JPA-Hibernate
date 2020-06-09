package entities;

import entities.embeddables.Address;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    /*
        In case of  < JPA 2.2 && Java se8

        @AttributeOverrides({
            @AttributeOverride(name = "no", column = @Column(name = "number")),
            @AttributeOverride(name = "str", column = @Column(name = "street"))
    })
     */

    /*
    -   java SE8 supports repeating the annotation
    -   And JPA 2.2 Onwards it is supported
     */
    @Embedded
    @AttributeOverride(name = "no", column = @Column(name = "number"))
    @AttributeOverride(name = "str", column = @Column(name = "street"))
    private Address address;

    public Integer getId() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
