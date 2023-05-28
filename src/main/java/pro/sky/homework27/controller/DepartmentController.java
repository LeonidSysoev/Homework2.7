package pro.sky.homework27.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework27.Employee;
import pro.sky.homework27.service.ServiceDepartament;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final ServiceDepartament serviceDepartament;

    public DepartmentController(ServiceDepartament serviceDepartament) {
        this.serviceDepartament = serviceDepartament;
    }

    @GetMapping("{id: \\d+}/{salary}/{max}")
    public Employee maxSalaryEmployeeInDepartment(@PathVariable(name = "Id") Integer Id) {
        return serviceDepartament.findMaxSalaryDepartament(Id);
    }

    @GetMapping("{id: \\d+}/{salary}/{min}")
    public Employee minSalaryEmployeeInDepartment(@PathVariable(name = "Id") Integer Id) {
        return serviceDepartament.findMinSalaryDepartament(Id);
    }

    @GetMapping("{id: \\d+}/{employeers}")
    public Collection<Employee> findEmployeesInDepartment(@PathVariable(name = "Id") Integer Id) {
        return serviceDepartament.findEmployeeInDepartament(Id);
    }

    @GetMapping("/employeers")
    public Map<Integer, List<Employee>> findEmployeesByDepartament() {
        return serviceDepartament.findEmployeesByDepartament();
    }
}
