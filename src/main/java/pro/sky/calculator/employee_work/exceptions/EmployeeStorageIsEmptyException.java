package pro.sky.calculator.employee_work.exceptions;

public class EmployeeStorageIsEmptyException extends RuntimeException {
    public EmployeeStorageIsEmptyException(String message) {
        super(message);
    }
}
