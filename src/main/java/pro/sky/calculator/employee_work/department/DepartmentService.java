package pro.sky.calculator.employee_work.department;

import pro.sky.calculator.employee_work.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Integer maxSalaryByDepartment(Integer departmentId);

    Integer minSalaryByDepartment(Integer departmentId);

    Integer sumSalaryByDepartment(Integer departmentId);

    List<Employee> employeeByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> allByDepartment();
}
