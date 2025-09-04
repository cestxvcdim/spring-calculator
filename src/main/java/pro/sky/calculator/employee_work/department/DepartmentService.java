package pro.sky.calculator.employee_work.department;

import pro.sky.calculator.employee_work.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalaryByDepartment(Integer departmentId);

    Employee minSalaryByDepartment(Integer departmentId);

    List<Employee> employeeByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> allByDepartment();
}
