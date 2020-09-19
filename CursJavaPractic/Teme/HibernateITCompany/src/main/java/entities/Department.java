package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Delete_Department_with_no_Employees", query = "delete Department where numberOfEmployees = 0"),
        @NamedQuery(name = "Display_Department_By_Floor", query = "select department from Department department where floorNumber= :floorNumber")

})

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "departments_name")
    private String name;
    @Column(name = "floor_number")
    private int floorNumber;
    @Column(name = "number_of_employees")
    private int numberOfEmployees;
    @Column(name = "department_head")
    private String departmentHead;


    public Department() {
    }

    public Department(String name, int floorNumber, int numberOfEmployees, String departmentHead) {
        this.name = name;
        this.floorNumber = floorNumber;
        this.numberOfEmployees = numberOfEmployees;
        this.departmentHead = departmentHead;
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

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    @Override
    public String toString() {
        return "Department: " + name + ", floor number: " + floorNumber + ", number Of Employees: " + numberOfEmployees + ", departmentHead:" + departmentHead;
    }
}
