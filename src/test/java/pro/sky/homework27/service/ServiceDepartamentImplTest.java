package pro.sky.homework27.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework27.Employee;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceDepartamentImplTest {
    @Mock
    private ServiceEmployeeBook serviceDepartamentMock;
    private ServiceDepartamentImpl service;

    @BeforeEach
    void setUp() {
        service = new ServiceDepartamentImpl(serviceDepartamentMock);
    }


    @Test
    void testFindMaxSalaryDepartament() {
        List<Employee> employees = List.of(
                new Employee("Ivan", "Petrov", 2, 20000),
                new Employee("Ivan", "Ivanov", 3, 20000),
                new Employee("Ivan", "Nikolaev", 2, 30000)
        );
        when(serviceDepartamentMock.showEmployees()).thenReturn(employees);
        assertNull(service.findMaxSalaryDepartament(1));
        assertEquals(employees.get(2), service.findMaxSalaryDepartament(2));
    }

    @Test
    void testFindMinSalaryDepartament() {
        List<Employee> employees = List.of(
                new Employee("Ivan", "Petrov", 2, 20000),
                new Employee("Ivan", "Ivanov", 3, 20000),
                new Employee("Ivan", "Nikolaev", 2, 30000)
        );
        when(serviceDepartamentMock.showEmployees()).thenReturn(employees);
        assertNull(service.findMinSalaryDepartament(1));
        assertEquals(employees.get(1), service.findMinSalaryDepartament(3));
    }

      @Test
    void testFindEmployeeInDepartament() {
        List<Employee> employees = List.of(
                new Employee("Ivan", "Petrov", 2, 20000),
                new Employee("Ivan", "Ivanov", 3, 20000),
                new Employee("Ivan", "Nikolaev", 2, 30000)
        );
        when(serviceDepartamentMock.showEmployees()).thenReturn(employees);
        var actual = service.findEmployeeInDepartament(2);
        assertEquals(2, actual.size());
        List<Employee> expected = List.of(
                new Employee("Ivan", "Petrov", 2, 20000),
                new Employee("Ivan", "Nikolaev", 2, 30000)
        );
        assertIterableEquals(expected, actual);

    }

    @Test
    void tastFindEmployeesByDepartament() {
        List<Employee> employees = List.of(
                new Employee("Ivan", "Petrov", 2, 20000),
                new Employee("Ivan", "Ivanov", 3, 20000),
                new Employee("Ivan", "Nikolaev", 2, 30000)
        );
        when(serviceDepartamentMock.showEmployees()).thenReturn(employees);
        Map<Integer,List<Employee>> actual = service.findEmployeesByDepartament();
        assertEquals(3, actual.size());

    }
}