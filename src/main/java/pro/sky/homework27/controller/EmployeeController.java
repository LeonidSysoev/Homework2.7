package pro.sky.homework27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework27.Employee;
import pro.sky.homework27.service.ServiceEmployeeBook;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final ServiceEmployeeBook employeeService;

    public EmployeeController(ServiceEmployeeBook employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam int departament, @RequestParam float salary) {
        return employeeService.addEmployee(firstName, lastName,  departament, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                 @RequestParam int departament, @RequestParam float salary) {
        return employeeService.findEmployee(firstName, lastName,  departament, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                   @RequestParam int departament, @RequestParam float salary) {
        return employeeService.removeEmployee(firstName, lastName,  departament, salary);
    }

    @GetMapping("/show")
    public Collection<Employee> show() {
        return employeeService.showEmployees();
    }
}

