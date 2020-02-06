package test;

import main.Calculator;
import main.CalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorImplTest {

    @Test
    public final void TestMultiply() {
        Calculator calculator = new CalculatorImpl();
        int a, b, res;

        a = 8;
        b = 9;
        res = a * b;
        assertTrue(calculator.multiply(a,b) == res,"a et b positif");

        a = 0;
        b = 9;
        res = a * b;
        assertTrue(calculator.multiply(a,b) == res,"a nul et b positif");

        a = 8;
        b = 0;
        res = a * b;
        assertTrue(calculator.multiply(a,b) == res,"a positif et b nul");

        a = 0;
        b = 0;
        res = a * b;
        assertTrue(calculator.multiply(a, b) == res, "a et b nul");

        a = -8;
        b = 9;
        res = a * b;
        assertTrue(calculator.multiply(a,b) == res,"a negatif et b positif");

        a = 8;
        b = -9;
        res = a * b;
        assertTrue(calculator.multiply(a,b) == res,"a positif et b negatif");

        a = -8;
        b = -9;
        res = a * b;
        assertTrue(calculator.multiply(a,b) == res,"a et b negatif");
    }

    @Test()
    public final void divideByZero() {
        Calculator calculator = new CalculatorImpl();
        final int a, b;

        a = 5;
        b = 0;

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(a,b);
        }, "a nul, b positif");

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(b,b);
        },"a et b nul");

    }

    @Test
    public final void TestDivide() {
        Calculator calc = new CalculatorImpl();
        int a, b, res;

        a = 10;
        b = 5;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a et positif, a sup à b");

        a = 5;
        b = 10;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a et positif, b sup à a");

        a = 0;
        b = 5;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a est nul, b positif");

        a = 0;
        b = -5;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a est nul, b negatif");

        a = -10;
        b = 5;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a et negatif, a est sup à b en valeur absolue");

        a = -5;
        b = 10;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a et negatif, a est inf à b en valeur absolue");

        a = 10;
        b = -5;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"b et negatif, a est sup à b en valeur absolue");

        a = 5;
        b = -10;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"b et negatif, a est inf à b en valeur absolue");

        a = -10;
        b = -5;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a et b negatif, a sup à b en valeur absolue");

        a = -5;
        b = -10;
        res = a / b;
        assertTrue(calc.divide(a,b)==res,"a et b negatif, b sup à a en valeur absolue");
    }

    @Test
    public final void TestAdd() {
        Calculator calculator = new CalculatorImpl();
        int a, b, res;

        a = 5;
        b = 5;
        res = a+b;
        if (calculator.add(a, b) != res) {
            fail("a et b positif");
        }

        a = 0;
        b = 5;
        res = a + b;
        if (calculator.add(a, b) != res) {
            fail("a  nul et b positif");
        }

        a = 5;
        b = 0;
        res = a + b;
        if (calculator.add(a, b) != res) {
            fail("a positif et b nul");
        }

        a = 0;
        b = 5;
        res = a + b;
        if (calculator.add(a, b) != res) {
            fail("a  nul et b positif");
        }

        a = 0;
        b = 0;
        res = a + b;
        if (calculator.add(a, b) != res) {
            fail("a  nul et b nul");
        }

        a = -5;
        b = 5;
        res = a + b;
        if (calculator.add(a, b) != res) {
            fail("a  negatif et b positif");
        }

        a = 5;
        b = -5;
        res = a + b;
        if (calculator.add(a, b) != res) {
            fail("a positif et b negatif");
        }

        a = -5;
        b = -5;
        res = a + b;
        if (calculator.add(a, b) != res) {
            fail("a negatif et b negatif");
        }
    }

    @Test
    public final void testSubstract() {
        Calculator calculator = new CalculatorImpl();
        int a, b, res;

        a = 18;
        b = 5;
        res = a-b;
        if (calculator.substract(a, b) != res) {
            fail("a superieur à b");
        }


        a = 5;
        b = 18;
        res = a-b;
        if (calculator.substract(a, b) != res) {
            fail("s superieur à a");
        }

        a = 5;
        b = 5;
        res = a-b;
        if (calculator.substract(a, b) != res) {
            fail("a = b");
        }

        a = 5;
        b = 0;
        res = a - b;
        if (calculator.substract(a, b) != res) {
            fail("a positif et b nul");
        }

        a = 0;
        b = 5;
        res = a - b;
        if (calculator.substract(a, b) != res) {
            fail("a  nul et b positif");
        }

        a = 0;
        b = 0;
        res = a - b;
        if (calculator.substract(a, b) != res) {
            fail("a  nul et b nul");
        }

        a = -5;
        b = 5;
        res = a - b;
        if (calculator.substract(a, b) != res) {
            fail("a  negatif et b positif");
        }

        a = 5;
        b = -5;
        res = a - b;
        if (calculator.substract(a, b) != res) {
            fail("a positif et b negatif");
        }

        a = -5;
        b = -5;
        res = a - b;
        if (calculator.substract(a, b) != res) {
            fail("a negatif et b negatif");
        }
    }
}