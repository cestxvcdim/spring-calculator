package pro.sky.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.calculator.calc.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    int num1;
    int num2;
    int numZero;

    @BeforeEach
    void setUp() {
        num1 = 100;
        num2 = 10;
        numZero = 0;
    }

    @Test
    public void plus() {
        int expected = calculatorService.plus(num1, num2);
        int ans = num1 + num2;
        assertEquals(expected, ans);

        int expected2 = calculatorService.plus(num2, num2);
        int ans2 = num2 + num2;
        assertEquals(expected2, ans2);
    }

    @Test
    public void minus() {
        int expected = calculatorService.minus(num1, num2);
        int ans = num1 - num2;
        assertEquals(expected, ans);

        int expected2 = calculatorService.minus(num2, num2);
        int ans2 = 0;
        assertEquals(expected2, ans2);
    }

    @Test
    public void multiply() {
        int expected = calculatorService.multiply(num1, num2);
        int ans = num1 * num2;
        assertEquals(expected, ans);

        int expected2 = calculatorService.multiply(num2, num2);
        int ans2 = num2 * num2;
        assertEquals(expected2, ans2);
    }

    @Test
    public void divide() {
        int expected = calculatorService.divide(num1, num2);
        int ans = num1 / num2;
        assertEquals(expected, ans);

        int expected2 = calculatorService.divide(num2, num2);
        int ans2 = 1;
        assertEquals(expected2, ans2);

        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(num2, numZero));
    }

}