package com.example.calculatorapp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTestHelperUnitTest {

    private static final double DELTA = 0.000001;

    @Test
    public void Given_TwoPositiveNumbers_When_addIsCalled_Then_CorrectSumIsReturned() {
        final double firstNumber = 10.0;
        final double secondNumber = 5.5;

        final double expected = 15.5;
        final double actual = CalculatorTestHelper.add(firstNumber, secondNumber);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void Given_PositiveAndNegativeNumbers_When_subtractIsCalled_Then_CorrectDifferenceIsReturned() {
        final double firstNumber = 10.0;
        final double secondNumber = -3.0;

        final double expected = 13.0;
        final double actual = CalculatorTestHelper.subtract(firstNumber, secondNumber);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void Given_NumberAndZero_When_multiplyIsCalled_Then_ResultIsZero() {
        final double firstNumber = 123.45;
        final double secondNumber = 0.0;

        final double expected = 0.0;
        final double actual = CalculatorTestHelper.multiply(firstNumber, secondNumber);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void Given_TwoNumbers_When_divideIsCalled_Then_CorrectQuotientIsReturned() {
        final double firstNumber = 15.0;
        final double secondNumber = 4.0;

        final double expected = 3.75;
        final double actual = CalculatorTestHelper.divide(firstNumber, secondNumber);

        assertEquals(expected, actual, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Given_DivisionByZero_When_divideIsCalled_Then_IllegalArgumentExceptionIsThrown() {
        final double firstNumber = 10.0;
        final double secondNumber = 0.0;

        CalculatorTestHelper.divide(firstNumber, secondNumber);
    }

    @Test
    public void Given_BaseAndPercent_When_percentIsCalled_Then_CorrectValueIsReturned() {
        final double base = 200.0;
        final double percent = 15.0;

        final double expected = 30.0;
        final double actual = CalculatorTestHelper.percent(base, percent);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void Given_NonZeroNumber_When_reciprocalIsCalled_Then_CorrectReciprocalIsReturned() {
        final double value = 4.0;

        final double expected = 0.25;
        final double actual = CalculatorTestHelper.reciprocal(value);

        assertEquals(expected, actual, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Given_Zero_When_reciprocalIsCalled_Then_IllegalArgumentExceptionIsThrown() {
        final double value = 0.0;

        CalculatorTestHelper.reciprocal(value);
    }

    @Test
    public void Given_PositiveNumber_When_negateIsCalled_Then_NegativeNumberIsReturned() {
        final double value = 42.0;

        final double expected = -42.0;
        final double actual = CalculatorTestHelper.negate(value);

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void Given_IntegerValue_When_formatResultIsCalled_Then_ResultHasNoDecimalPart() {
        final double value = 21.0;

        final String expected = "21";
        final String actual = CalculatorTestHelper.formatResult(value);

        assertEquals(expected, actual);
    }

    @Test
    public void Given_FractionalValue_When_formatResultIsCalled_Then_ResultKeepsDecimalPart() {
        final double value = 3.14;

        final String expected = "3.14";
        final String actual = CalculatorTestHelper.formatResult(value);

        assertEquals(expected, actual);
    }
}
