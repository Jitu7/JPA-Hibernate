package entites;

import javax.persistence.*;

@Entity(name = "Student")
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Embedded
    @AssociationOverride(name = "professors",
            joinTable = @JoinTable(name = "student_prof",
                                joinColumns = @JoinColumn(name = "student"),
                                inverseJoinColumns = @JoinColumn(name = "prof")))
    private ProfessorDetails professorDetails;

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

    public ProfessorDetails getProfessorDetails() {
        return professorDetails;
    }

    public void setProfessorDetails(ProfessorDetails professorDetails) {
        this.professorDetails = professorDetails;
    }
}
