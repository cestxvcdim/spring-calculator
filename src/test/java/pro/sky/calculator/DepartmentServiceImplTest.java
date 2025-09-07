package pro.sky.calculator;

import pro.sky.calculator.employee_work.department.DepartmentService;
import pro.sky.calculator.employee_work.department.DepartmentServiceImpl;
import pro.sky.calculator.employee_work.employee.Employee;
import pro.sky.calculator.employee_work.employee.EmployeeServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepartmentServiceImplTest {

    private DepartmentService departmentService;
    private List<Employee> mockEmployees;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentServiceImpl();

        mockEmployees = List.of(
                new Employee("Vadim", "Anton", 1, 5000),
                new Employee("Liza", "Katya", 1, 5500),
                new Employee("Zhenya", "Kolya", 2, 6000)
        );

    }

    @Test
    void maxSalaryByDepartment() {

        try (MockedStatic<EmployeeServiceImpl> mockedStatic = Mockito.mockStatic(EmployeeServiceImpl.class)) {
            mockedStatic.when(EmployeeServiceImpl::getAll).thenReturn(mockEmployees);

            Integer actual = departmentService.maxSalaryByDepartment(1);
            assertEquals(5500, actual);
        }
    }

    @Test
    void minSalaryByDepartment() {

        try (MockedStatic<EmployeeServiceImpl> mockedStatic = Mockito.mockStatic(EmployeeServiceImpl.class)) {
            mockedStatic.when(EmployeeServiceImpl::getAll).thenReturn(mockEmployees);

            Integer actual = departmentService.minSalaryByDepartment(1);
            assertEquals(5000, actual);
        }
    }

    @Test
    void sumSalaryByDepartment() {

        try (MockedStatic<EmployeeServiceImpl> mockedStatic = Mockito.mockStatic(EmployeeServiceImpl.class)) {
            mockedStatic.when(EmployeeServiceImpl::getAll).thenReturn(mockEmployees);

            Integer actual = departmentService.sumSalaryByDepartment(1);
            assertEquals(10500, actual);
        }
    }

    @Test
    void employeeByDepartment() {

        try (MockedStatic<EmployeeServiceImpl> mockedStatic = Mockito.mockStatic(EmployeeServiceImpl.class)) {
            mockedStatic.when(EmployeeServiceImpl::getAll).thenReturn(mockEmployees);

            List<Employee> actual = departmentService.employeeByDepartment(1);
            assertEquals(List.of(
                    new Employee("Vadim", "Anton", 1, 5000),
                    new Employee("Liza", "Katya", 1, 5500)
            ), actual);
        }
    }

    @Test
    void allByDepartment() {

        try (MockedStatic<EmployeeServiceImpl> mockedStatic = Mockito.mockStatic(EmployeeServiceImpl.class)) {
            mockedStatic.when(EmployeeServiceImpl::getAll).thenReturn(mockEmployees);

            Map<Integer, List<Employee>> actual = departmentService.allByDepartment();
            assertEquals(Map.of(
                    1, List.of(
                            new Employee("Vadim", "Anton", 1, 5000),
                            new Employee("Liza", "Katya", 1, 5500)
                    ),
                    2, List.of(
                            new Employee("Zhenya", "Kolya", 2, 6000)
                    )), actual);
        }
    }
}