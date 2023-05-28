package pro.sky.homework27.service;

import pro.sky.homework27.Employee;

import java.util.Collection;
import java.util.Collections;

public interface ServiceEmployeeBook {


    Employee addEmployee(String firstName, String lastName, int departament, float salary);

    Employee findEmployee(String firstName, String lastName, int departament, float salary);

    Employee removeEmployee(String firstName, String lastName, int departament, float salary);

    Collection<Employee> showEmployees();
}

