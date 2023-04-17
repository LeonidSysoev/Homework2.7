package pro.sky.homework27.service;

import org.springframework.stereotype.Service;
import pro.sky.homework27.Employee;
import pro.sky.homework27.EmployeeNotFoundException;
import pro.sky.homework27.EmployeesBookAlreadyAddedException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service

public class ServiceEmployeeBookImpl implements ServiceEmployeeBook {
    private final Map<String, Employee> employeesBook;

    public ServiceEmployeeBookImpl() {
        this.employeesBook = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = employee.getFullName();
        if (employeesBook.containsKey(key)) {
            throw new EmployeesBookAlreadyAddedException("Сотрудник присутствует в списке!");
        }
        employeesBook.put(key, employee);
        return employee;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = employee.getFullName();
        if (employeesBook.containsKey(key)) {
            return employeesBook.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = employee.getFullName();
        if (employeesBook.containsKey(key)) {
            return employeesBook.remove(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    public Collection<Employee> showEmployees() {
        return Collections.unmodifiableCollection(employeesBook.values());
    }

}
