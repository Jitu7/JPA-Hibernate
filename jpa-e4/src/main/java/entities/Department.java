package entities;

import entities.pk.DepartmentPK;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "department")
@IdClass(DepartmentPK.class)
public class Department {

    @Id
    private String code;

    @Id
    @Column(name = "number")
//    private Integer number;
    private Integer no;

    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer number) {
        this.no = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
