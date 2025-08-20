package pro.sky.calculator.employee_work.employee;

public interface EmployeeService {
    Employee add(String firstName, String lastName, Integer department, Integer salary);

    Employee remove(String firstName, String lastName, Integer department, Integer salary);

    Employee find(String firstName, String lastName, Integer department, Integer salary);

}
