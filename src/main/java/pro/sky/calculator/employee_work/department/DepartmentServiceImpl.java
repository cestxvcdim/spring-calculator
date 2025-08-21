package pro.sky.calculator.employee_work.department;


import pro.sky.calculator.employee_work.employee.Employee;
import pro.sky.calculator.employee_work.employee.EmployeeServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final static Set<Employee> employees = EmployeeServiceImpl.getAll();

    @Override
    public Employee maxSalaryByDepartment(Integer departmentId) {
        Optional<Employee> maxSalary = employees.stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).max(
                Comparator.comparingInt(Employee::getSalary)
        );

        return maxSalary.orElse(null);
    }

    @Override
    public Employee minSalaryByDepartment(Integer departmentId) {
        Optional<Employee> minSalary = employees.stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).min(
                Comparator.comparingInt(Employee::getSalary)
        );

        return minSalary.orElse(null);
    }

    @Override
    public List<Employee> employeeByDepartment(Integer departmentId) {

        return employees.stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())).toList();
    }

    @Override
    public Map<Integer, List<Employee>> allByDepartment() {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}