package persistance.entities.structures;

import persistance.entities.products.Chemicals.Cement;
import persistance.entities.products.Chemicals.Paint;
import persistance.entities.products.Tools.Screwdriver;

import javax.persistence.*;
import java.util.Set;
@NamedQueries({

        @NamedQuery(name = "findDepartmentByName",query="select department from Department department where name= :name"),
        @NamedQuery(name = "deleteDepartmentByName",query = "delete from Department where name= :name"),
        @NamedQuery(name = "updateDepartmentName",query = "update from Department department set name= :newName where name= :name")
})

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Cement> cementSet;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Paint> paintSet;
    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Screwdriver> screwdriverSet;


    public Department(String name) {
        this.name = name;
    }

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Cement> getCementSet() {
        return cementSet;
    }

    public void setCementSet(Set<Cement> cementSet) {
        this.cementSet = cementSet;
    }

    public Set<Paint> getPaintSet() {
        return paintSet;
    }

    public void setPaintSet(Set<Paint> paintSet) {
        this.paintSet = paintSet;
    }

    public Set<Screwdriver> getScrewdriverSet() {
        return screwdriverSet;
    }

    public void setScrewdriverSet(Set<Screwdriver> screwdriverSet) {
        this.screwdriverSet = screwdriverSet;
    }

    @Override
    public String toString() {
        return "Department: " + name;
    }
}
