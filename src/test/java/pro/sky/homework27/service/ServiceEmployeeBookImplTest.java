package pro.sky.homework27.service;

import org.junit.jupiter.api.Test;
import pro.sky.homework27.Employee;
import pro.sky.homework27.EmployeeNotFoundException;
import pro.sky.homework27.EmployeesBookAlreadyAddedException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceEmployeeBookImplTest {
    ServiceEmployeeBook serviceEmployeeBook = new ServiceEmployeeBookImpl();

    @Test
    void addEmployee() {
        Employee actual = serviceEmployeeBook.addEmployee("Ivan", "Ivanov", 1, 10000);
        Employee expected = new Employee("Ivan", "Ivanov", 1, 10000);
        assertEquals(expected, actual);
    }

    @Test
    void addEmployeeAlreadyAddedException() {
        serviceEmployeeBook.addEmployee("Ivan", "Ivanov", 1, 10000);
        assertThrows(EmployeesBookAlreadyAddedException.class,
                () -> serviceEmployeeBook.addEmployee("Ivan", "Ivanov", 1, 10000));

    }


    @Test
    void findEmployee() {
        Employee actual = serviceEmployeeBook.addEmployee("Ivan", "Ivanov", 1, 10000);
        Employee expected = serviceEmployeeBook.findEmployee("Ivan", "Ivanov", 1, 10000);
        assertEquals(expected, actual);
    }

    @Test
    void findEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> serviceEmployeeBook.findEmployee("Ivan", "Ivanov", 1, 10000));
    }

    @Test
    void removeEmployee() {
        Employee actual = serviceEmployeeBook.addEmployee("Ivan", "Ivanov", 1, 10000);
        Employee expected = serviceEmployeeBook.removeEmployee("Ivan", "Ivanov", 1, 10000);
        assertEquals(expected, actual);
    }

    @Test
    void removeEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> serviceEmployeeBook.removeEmployee("Ivan", "Ivanov", 1, 10000));
    }

    @Test
    void testAllEmployee() {
        serviceEmployeeBook.addEmployee("Ivan", "Ivanov", 1, 10000);
        serviceEmployeeBook.addEmployee("Ivan", "Petrov", 2, 20000);
        Collection<Employee> employees = serviceEmployeeBook.showEmployees();
        assertEquals(2, employees.size());
        List<Employee> expected = List.of(
                new Employee("Ivan", "Ivanov", 1, 10000),
                new Employee("Ivan", "Petrov", 2, 20000));
        assertIterableEquals(expected, employees);
    }

}