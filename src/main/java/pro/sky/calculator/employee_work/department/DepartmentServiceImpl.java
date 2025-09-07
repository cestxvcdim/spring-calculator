package pro.sky.calculator.employee_work.department;


import pro.sky.calculator.employee_work.employee.Employee;
import pro.sky.calculator.employee_work.employee.EmployeeServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public Integer maxSalaryByDepartment(Integer departmentId) {
        Optional<Employee> maxSalary = EmployeeServiceImpl.getAll().stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).max(
                Comparator.comparingInt(Employee::getSalary)
        );

        return maxSalary.isPresent() ? maxSalary.get().getSalary() : 0;
    }

    @Override
    public Integer minSalaryByDepartment(Integer departmentId) {
        Optional<Employee> minSalary = EmployeeServiceImpl.getAll().stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())
        ).min(
                Comparator.comparingInt(Employee::getSalary)
        );

        return minSalary.isPresent() ? minSalary.get().getSalary() : 0;
    }

    @Override
    public Integer sumSalaryByDepartment(Integer departmentId) {
        return EmployeeServiceImpl.getAll().stream()
                .filter(e1 -> departmentId.equals(e1.getDepartment()))
                .mapToInt(Employee::getSalary).sum();
    }

    @Override
    public List<Employee> employeeByDepartment(Integer departmentId) {

        return EmployeeServiceImpl.getAll().stream().filter(
                e1 -> departmentId.equals(e1.getDepartment())).toList();
    }

    @Override
    public Map<Integer, List<Employee>> allByDepartment() {
        return EmployeeServiceImpl.getAll().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}