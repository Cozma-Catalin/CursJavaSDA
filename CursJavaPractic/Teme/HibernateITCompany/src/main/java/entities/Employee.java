package entities;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Delete_Employee", query = "delete Employee where age>= 65"),
        @NamedQuery(name = "Change_Position", query = "update Employee set position= :position where age>= 35 and age<= 40"),
        @NamedQuery(name = "Display_Employees_by_Department", query = "select employee from Employee employee where department= :department"),
        @NamedQuery(name = "Display_Employyes_by_Department_and_Position", query = "select employee from Employee employee where department= :department and position= :position")

})

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "employees_name")
    private String name;
    @Column(name = "employees_surname")
    private String surname;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private int age;
    @Column(name = "department")
    private String department;
    @Column(name = "position")
    private String position;


    public Employee() {
    }


    public Employee(String name, String surname, String address, int age, String department, String position) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.age = age;
        this.department = department;
        this.position = position;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee: " + name + surname + ", address: " + address + ", age:" + age + ", department:" + department + ", employeesPosition: " + position;
    }
}
