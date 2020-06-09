package entities;

import entities.embeddables.BuildingPK;

import javax.persistence.*;

@Entity(name = "Building")
@Table(name = "building")
public class Building {

    @EmbeddedId
    @AttributeOverride(name = "no", column = @Column(name = "number"))
    private BuildingPK buildingPK;

    private String name;

    public BuildingPK getBuildingPK() {
        return buildingPK;
    }

    public void setBuildingPK(BuildingPK buildingPK) {
        this.buildingPK = buildingPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
