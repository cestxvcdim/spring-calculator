package pro.sky.calculator.employee;

import org.springframework.stereotype.Service;
import pro.sky.calculator.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.calculator.employee.exceptions.EmployeeNotFoundException;
import pro.sky.calculator.employee.exceptions.EmployeeStorageIsEmptyException;
import pro.sky.calculator.employee.exceptions.EmployeeStorageIsFullException;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {
    private final Set<Employee> employees = new HashSet<>();
    private final int maxSize = 1000;

    private void checkArgs(String firstName, String lastName) {
        if (firstName == null || lastName == null) {
            throw new IllegalArgumentException("firstName и lastName не должны быть null.");
        }
        if (firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("firstName и lastName не должны быть пустые.");
        }
    }

    public Employee find(String firstName, String lastName) {
        checkArgs(firstName, lastName);
        Employee emp = new Employee(firstName, lastName);
        if (employees.contains(emp)) {
            return emp;
        }
        else {
            throw new EmployeeNotFoundException("Сотрудник не найден.");
        }
    }

    public Employee add(String firstName, String lastName) {
        checkArgs(firstName, lastName);
        int curSize = employees.size();
        if (curSize == maxSize) {
            throw new EmployeeStorageIsFullException("Достигнут лимит сотрудников в фирме.");
        }
        Employee emp = new Employee(firstName, lastName);
        if (employees.contains(emp)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже находится в фирме.");
        }
        employees.add(emp);
        return emp;
    }

    public Employee remove(String firstName, String lastName) {
        checkArgs(firstName, lastName);
        int curSize = employees.size();
        if (curSize == 0) {
            throw new EmployeeStorageIsEmptyException("В фирме нет сотрудников.");
        }
        Employee emp = find(firstName, lastName);
        employees.remove(emp);
        return emp;
    }

    public Set<Employee> getAll() {
        return employees;
    }
}
