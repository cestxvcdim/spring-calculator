package pro.sky.calculator.employee.exceptions;

public class EmployeeStorageIsEmptyException extends RuntimeException {
    public EmployeeStorageIsEmptyException(String message) {
        super(message);
    }
}
