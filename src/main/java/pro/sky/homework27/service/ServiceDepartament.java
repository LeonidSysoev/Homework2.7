package pro.sky.homework27.service;

import pro.sky.homework27.Employee;

import java.util.List;
import java.util.Map;

public interface ServiceDepartament {
    Employee findMinSalaryDepartament(Integer departament);

    Employee findMaxSalaryDepartament(Integer departament);

    List<Employee> findEmployeeInDepartament(Integer departament);

    Map<Integer, List<Employee>> findEmployeesByDepartament();
}
