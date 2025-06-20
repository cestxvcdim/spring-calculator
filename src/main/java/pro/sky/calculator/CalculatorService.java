package pro.sky.calculator;

public interface CalculatorService {
    default String greet() {
        return "<b>Добро пожаловать в калькулятор</b>";
    };
    int plus(int a, int b);
    int minus(int a, int b);
    int multiply(int a, int b);
    int divide(int a, int b);

}
