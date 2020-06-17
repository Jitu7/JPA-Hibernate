package entites;

import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Embeddable
public class ProfessorDetails {

    @ManyToMany
    private Set<Professor> professors;

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }
}
