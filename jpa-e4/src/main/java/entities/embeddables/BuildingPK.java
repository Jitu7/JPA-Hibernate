package entities.embeddables;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BuildingPK implements Serializable {

//    private Integer number;
    private Integer no;
    private String code;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer number) {
        this.no = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
