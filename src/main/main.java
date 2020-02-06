package main;

public class main {

    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();

        System.out.println(calculator.add(5,-6));

        System.out.println(calculator.substract(4,-4));

        System.out.println(calculator.multiply(6,-3));

        System.out.println(calculator.divide(-10,-5));

    }
}
