package entites;

import javax.persistence.*;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Embedded
    @AttributeOverride(name = "contractNo", column = @Column(name = "contract_no"))
    @AssociationOverride(name = "department",
            joinColumns = @JoinColumn(name = "department"))
    private DepartmentDetails departmentDetails;

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

    public DepartmentDetails getDepartmentDetails() {
        return departmentDetails;
    }

    public void setDepartmentDetails(DepartmentDetails departmentDetails) {
        this.departmentDetails = departmentDetails;
    }
}
