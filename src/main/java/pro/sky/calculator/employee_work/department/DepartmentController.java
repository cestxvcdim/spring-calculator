package pro.sky.calculator.employee_work.department;

import pro.sky.calculator.employee_work.employee.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/salary/max")
    public Integer maxSalary(@PathVariable Integer id) {
        return departmentService.maxSalaryByDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public Integer minSalary(@PathVariable Integer id) {
        return departmentService.minSalaryByDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public Integer sumSalary(@PathVariable Integer id) {
        return departmentService.sumSalaryByDepartment(id);
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> EmployeesByDepartment(@PathVariable Integer id) {
        return departmentService.employeeByDepartment(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> allEmployeesByDepartment() {
        return departmentService.allByDepartment();
    }
}
