package pro.sky.homework27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework27.Employee;
import pro.sky.homework27.service.ServiceDepartament;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/departments")

public class DepartmentController {
    private final ServiceDepartament serviceDepartament;

    public DepartmentController(ServiceDepartament serviceDepartament) {
        this.serviceDepartament = serviceDepartament;
    }

    @GetMapping("/max_salary")
    public Employee maxSalaryEmployeeInDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
        return serviceDepartament.findMaxSalaryDepartament(departmentId);
    }

    @GetMapping("/min_salary")
    public Employee minSalaryEmployeeInDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
        return serviceDepartament.findMinSalaryDepartament(departmentId);
    }

    @GetMapping("/all")
    public Collection<Employee> findEmployeesInDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
        return serviceDepartament.findEmployeeInDepartament(departmentId);
    }

    @GetMapping("/allemployeers")
    public Collection<Employee> findEmployeesByDepartament() {
        return serviceDepartament.findEmployeesByDepartament();
    }
}
