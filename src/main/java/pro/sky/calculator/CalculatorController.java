package pro.sky.calculator;


import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting() {
        return calculatorService.greet();
    }

    @GetMapping(path="/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping(path="/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping(path="/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping(path="/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, result);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public String handleBadArgs(IllegalArgumentException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public String handleMissingParam(MissingServletRequestParameterException ex) {
        return String.format("Parameter '%s' is required", ex.getParameterName());
    }
}
