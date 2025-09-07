package pro.sky.calculator.employee_work.employee;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.calculator.employee_work.exceptions.EmployeeAlreadyAddedException;
import pro.sky.calculator.employee_work.exceptions.EmployeeNotFoundException;
import pro.sky.calculator.employee_work.exceptions.EmployeeStorageIsEmptyException;
import pro.sky.calculator.employee_work.exceptions.EmployeeStorageIsFullException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("department") Integer department,
                                @RequestParam("salary") Integer salary) {

        return employeeService.add(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("department") Integer department,
                                   @RequestParam("salary") Integer salary) {

        return employeeService.remove(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("department") Integer department,
                                 @RequestParam("salary") Integer salary) {

        return employeeService.find(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/all")
    public List<Employee> getAllEmployees() {
        return EmployeeServiceImpl.getAll();
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
