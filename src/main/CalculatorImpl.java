package main;

public class CalculatorImpl implements Calculator {
    @Override
    public int multiply(int a, int b) {
        int res = 0;
        if (b > 0) {
            while (b-- != 0) {
                res+=a;
            }
        } else if (b < 0) {
            while (b++ != 0) {
                res+=a;
            }
            res = -res;
        }
        return res;
    }

    @Override
    public int divide(int a, int b) {
        boolean negatif = false;
        int res = 0;
        if (b == 0) {
            throw new ArithmeticException();
        }
        if (a < 0) {
            negatif = !negatif;
            a = -a;
        }
        if (b < 0) {
            negatif = ! negatif;
            b = -b;
        }
        while (a - b >= 0) {
            res ++;
            a -= b;
        }
        if (negatif) {
            res = - res;
        }

        return res;
    }

    @Override
    public int add(int a, int b) {
        int res = a;
        if (b > 0) {
            while (b-- != 0) {
                res ++;
            }
        } else if (b < 0) {
            while (b++ != 0) {
                res--;
            }
        }
        return res;
    }

    @Override
    public int substract(int a, int b) {
        int res = a;

        if (b > 0) {
            while (b-- != 0) {
                res--;
            }
        } else if (b < 0) {
            while (b++ != 0) {
                res++;
            }
        }


        return res;
    }
}
