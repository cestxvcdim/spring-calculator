package pro.sky.calculator;

import pro.sky.calculator.employee_work.employee.Employee;
import pro.sky.calculator.employee_work.employee.EmployeeService;
import pro.sky.calculator.employee_work.employee.EmployeeServiceImpl;

import pro.sky.calculator.employee_work.exceptions.EmployeeAlreadyAddedException;
import pro.sky.calculator.employee_work.exceptions.EmployeeNotFoundException;
import pro.sky.calculator.employee_work.exceptions.EmployeeStorageIsFullException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {


    private static final EmployeeService employeeService = new EmployeeServiceImpl();
    String firstName;
    String secondName;
    Integer salary;
    Integer department;


    @BeforeEach
    void setUp() {
        firstName = "Ivan";
        secondName = "Ivanov";
        salary = 1350;
        department = 1;
    }

    @Test
    public void addEmployee() {

        Employee newEmpl = employeeService.add(firstName, secondName, department, salary);
        assertEquals(newEmpl, new Employee(firstName, secondName, department, salary));

        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(firstName, secondName, department, salary));

        for (int i = 1; i < 1000; ++i) {
            employeeService.add(firstName + i, secondName, department, salary);
        }
        assertThrows(EmployeeStorageIsFullException.class,
                () -> employeeService.add(firstName + "m", secondName, department, salary));


        employeeService.remove(firstName, secondName, department, salary);
        for (int i = 1; i < 1000; ++i) {
            employeeService.remove(firstName + i, secondName, department, salary);
        }
    }

    @Test
    public void popEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.remove(firstName, secondName, department, salary));

        Employee newEmpl = employeeService.add(firstName, secondName, department, salary);
        assertEquals(newEmpl, employeeService.remove(firstName, secondName, department, salary));
    }


    @Test
    public void findEmployee() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.find(firstName, secondName, department, salary));

        employeeService.add(firstName, secondName, department, salary);
        Employee newEmpl = employeeService.find(firstName, secondName, department, salary);
        assertEquals(newEmpl, employeeService.find(firstName, secondName, department, salary));
    }
}
