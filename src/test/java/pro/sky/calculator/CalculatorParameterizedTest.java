package pro.sky.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.calculator.calc.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceParameterizedTest {

    CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of(50, 21, 71),
                Arguments.of(30, 35, 65)
        );
    }

    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of(50, 21, 29),
                Arguments.of(30, 35, -5)
        );
    }


    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of(50, 21, 1050),
                Arguments.of(30, 35, 1050)
        );
    }

    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of(50, 21, 50 / 21),
                Arguments.of(30, 35, 30 / 35)
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    public void checkPlusParams(int a, int b, int expected) {
        int res = calculatorService.plus(a, b);
        assertEquals(res, expected);
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    public void checkMinusParams(int a, int b, int expected) {
        int res = calculatorService.minus(a, b);
        assertEquals(res, expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyParams")
    public void checkMultiplyParams(int a, int b, int expected) {
        int res = calculatorService.multiply(a, b);
        assertEquals(res, expected);
    }


    @ParameterizedTest
    @MethodSource("divideParams")
    public void checkDivideParams(int a, int b, int expected) {
        int res = calculatorService.divide(a, b);
        assertEquals(res, expected);
    }

}