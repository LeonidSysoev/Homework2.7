package pro.sky.homework27.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework27.Employee;
import pro.sky.homework27.EmployeeNotCorrect;
import pro.sky.homework27.EmployeeNotFoundException;
import pro.sky.homework27.EmployeesBookAlreadyAddedException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service

public class ServiceEmployeeBookImpl implements ServiceEmployeeBook {
    private final Map<String, Employee> employeesBook;

    public ServiceEmployeeBookImpl() {
        this.employeesBook = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName, int departament, float salary) {
        checkValid(firstName, lastName);
        Employee employee = new Employee(capitalize(firstName.toLowerCase()),
                capitalize(lastName.toLowerCase()), departament, salary);
        String key = employee.getFullName();
        if (employeesBook.containsKey(key)) {
            throw new EmployeesBookAlreadyAddedException("Сотрудник присутствует в списке!");
        }
        employeesBook.put(key, employee);
        return employee;
    }


    @Override
    public Employee findEmployee(String firstName, String lastName, int departament, float salary) {
        checkValid(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departament, salary);
        String key = employee.getFullName();
        if (employeesBook.containsKey(key)) {
            return employeesBook.get(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    public Employee removeEmployee(String firstName, String lastName, int departament, float salary) {
        checkValid(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, departament, salary);
        String key = employee.getFullName();
        if (employeesBook.containsKey(key)) {
            return employeesBook.remove(key);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    public Collection<Employee> showEmployees() {
        return Collections.unmodifiableCollection(employeesBook.values());
    }

    private void checkValid(String firstName, String lastName) {
        if (!(isAlpha(firstName)) || !(isAlpha(lastName)))
            throw new EmployeeNotCorrect("Имя введено некорректно!");
    }

}
