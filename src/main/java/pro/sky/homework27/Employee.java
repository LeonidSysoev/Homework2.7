package pro.sky.homework27;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int departament;
    private float salary;

    public Employee(String firstName, String lastName, int departament, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departament = departament;
        this.salary = salary;
    }

    public int getDepartament() {
        return departament;
    }

    public float getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName(){return firstName + ' ' + lastName;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}