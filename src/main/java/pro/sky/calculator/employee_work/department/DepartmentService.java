package pro.sky.calculator.employee_work.department;

import pro.sky.calculator.employee_work.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public Employee maxSalaryByDepartment(Integer departmentId);

    public Employee minSalaryByDepartment(Integer departmentId);

    public List<Employee> employeeByDepartment(Integer departmentId);

    public Map<Integer, List<Employee>> allByDepartment();
}
