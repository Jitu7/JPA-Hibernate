package entities.pk;

import java.io.Serializable;

public class DepartmentPK implements Serializable {

//    private String code;
    private String name;
//    private Integer number;
    private Integer no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer number) {
        this.no = number;
    }
}
