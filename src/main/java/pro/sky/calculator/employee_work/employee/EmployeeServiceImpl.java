package pro.sky.calculator.employee_work.employee;

import org.springframework.stereotype.Service;
import pro.sky.calculator.employee_work.exceptions.EmployeeAlreadyAddedException;
import pro.sky.calculator.employee_work.exceptions.EmployeeNotFoundException;
import pro.sky.calculator.employee_work.exceptions.EmployeeStorageIsFullException;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final static Set<Employee> employees = new HashSet<>();
    private final int maxSize = 1000;

    @Override
    public Employee find(String firstName, String lastName, Integer department, Integer salary) {
        Employee e = new Employee(firstName, lastName, department, salary);
        if (employees.contains(e)) {
            return e;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Employee add(String firstName, String lastName, Integer department, Integer salary) {
        if (employees.size() == maxSize) {
            throw new EmployeeStorageIsFullException("Employee storage is already full");
        }

        Employee e = new Employee(firstName, lastName, department, salary);

        if (employees.contains(e)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }

        employees.add(e);

        return e;
    }

    @Override
    public Employee remove(String firstName, String lastName, Integer department, Integer salary) {
        Employee e = new Employee(firstName, lastName, department, salary);
        if (employees.contains(e)) {
            employees.remove(e);
            return e;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public static Set<Employee> getAll() {
        return employees;
    }
}
