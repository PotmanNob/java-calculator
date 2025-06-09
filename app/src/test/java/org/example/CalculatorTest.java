/*
 * Don't touch please
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        assertNotNull(calculator, "Calculator should be initialized");
    }

    @Test
    void canAdd() {
        assertEquals(4.0, calculator.calculate(2, 2, '+'));
    }

    @Test
    void canSubtract() {
        assertEquals(3, calculator.calculate(5, 2, '-'));
    }

    @Test
    void canMultiply() {
        assertEquals(6, calculator.calculate(2, 3, '*'));
    }

    @Test
    void canDivide() {
        assertEquals(2, calculator.calculate(6, 3, '/'));
    }

    @Test
    void canHandleDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(1, 0, '/');
        });
        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void canAddRandom() {
        double a = randomNumber();
        double b = randomNumber();
        assertEquals(a + b, calculator.calculate(a, b, '+'));
    }

    @Test
    void canSubtractRandom() {
        double a = randomNumber();
        double b = randomNumber();
        assertEquals(a - b, calculator.calculate(a, b, '-'));
    }

    @Test
    void canMultiplyRandom() {
        double a = randomNumber();
        double b = randomNumber();
        assertEquals(a * b, calculator.calculate(a, b, '*'));
    }

    @Test
    void canDivideRandom() {
        double a = randomNumber();
        double b = randomNumber();
        if (b == 0) {
            b = 1; // Avoid division by zero
        }
        assertEquals(a / b, calculator.calculate(a, b, '/'));
    }

    private double randomNumber() {
        return Math.random() * 1_000_000;
    }
}
