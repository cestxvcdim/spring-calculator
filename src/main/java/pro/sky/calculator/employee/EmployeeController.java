package pro.sky.calculator.employee;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.calculator.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.calculator.employee.exceptions.EmployeeNotFoundException;
import pro.sky.calculator.employee.exceptions.EmployeeStorageIsEmptyException;
import pro.sky.calculator.employee.exceptions.EmployeeStorageIsFullException;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping(path = "/all")
    public Set<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequest(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(EmployeeNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleAlreadyExists(EmployeeAlreadyAddedException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    @ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
    public String handleStorageFull(EmployeeStorageIsFullException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(EmployeeStorageIsEmptyException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleStorageEmpty(EmployeeStorageIsEmptyException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAll(Exception ex) {
        return "Произошла непредвиденная ошибка: " + ex.getMessage();
    }

}
