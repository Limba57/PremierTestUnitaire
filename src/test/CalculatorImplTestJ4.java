package test;

import main.Calculator;
import main.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorImplTestJ4 {

    @Test(expected = ArithmeticException.class)
    public void divideByZero() {
        Calculator calculator = new CalculatorImpl();
        int a, b, res;

        a = 5;
        b = 0;
        res=0;

        calculator.divide(a, b);
    }

}