package entites;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DepartmentDetails {

    private String contractNo;

    @ManyToOne
    private Department department;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contactNo) {
        this.contractNo = contactNo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
