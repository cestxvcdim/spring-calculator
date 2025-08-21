package pro.sky.calculator.employee_work.department;

import pro.sky.calculator.employee_work.employee.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") Integer depId) {
        return departmentService.maxSalaryByDepartment(depId);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("departmentId") Integer depId) {
        return departmentService.minSalaryByDepartment(depId);
    }

    @GetMapping(path = "/all", params = "departmentId")
    public List<Employee> EmployeesByDepartment(@RequestParam("departmentId") Integer depId) {
        return departmentService.employeeByDepartment(depId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return departmentService.allByDepartment();
    }
}
