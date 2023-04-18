package pro.sky.homework27.service;

import pro.sky.homework27.Employee;

public interface ServiceEmployeeBook {


    Employee addEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
}
