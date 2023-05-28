package pro.sky.homework27.service;

import org.springframework.stereotype.Service;
import pro.sky.homework27.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service

public class ServiceDepartamentImpl implements ServiceDepartament {
    private final ServiceEmployeeBook employeeBook;

    public ServiceDepartamentImpl(ServiceEmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }


    public Employee findMinSalaryDepartament(Integer departament) {
        return employeeBook.showEmployees().stream()
                .filter(e -> e.getDepartament() == departament)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElse(null);
    }

    public Employee findMaxSalaryDepartament(Integer departament) {
        return employeeBook.showEmployees().stream()
                .filter(e -> e.getDepartament() == departament)
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElse(null);
    }

    public List<Employee> findEmployeeInDepartament(Integer departament) {
        return employeeBook.showEmployees().stream()
                .filter(e -> e.getDepartament() == departament)
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeesByDepartament() {
        return employeeBook.showEmployees().stream()
                .sorted(Comparator.comparing(Employee::getDepartament))
                .collect(Collectors.toList());
    }
}
