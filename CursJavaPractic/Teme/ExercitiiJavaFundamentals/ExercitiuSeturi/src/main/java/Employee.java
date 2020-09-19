import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String department;

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee " + firstName + ',' + lastName + ',' + department;
    }

}
