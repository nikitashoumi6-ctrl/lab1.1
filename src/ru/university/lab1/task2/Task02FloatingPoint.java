package ru.university.lab1.task2;

public class Task02FloatingPoint {
    public void run() {
        demonstratePointOnePlusPointTwo();
        demonstrateLoopAddition();
        demonstrateEpsilonComparison();
        demonstrateSpecialValues();
        demonstrateRounding();
        demonstrateFloatVsDouble();
    }

    private void demonstratePointOnePlusPointTwo() {
        System.out.println(" 0.1 + 0.2 ");
        double result = 0.1 + 0.2;
        //результат не равен 0.3 из-за невозможности точного представления 0.1 и 0.2 в двоичной системе
        System.out.println("0.1 + 0.2 = " + result);
    }

    private void demonstrateLoopAddition() {
        System.out.println("\n Сложение 0.1 десять раз ");
        double sum = 0;
        for (int i = 0; i < 10; i++) sum += 0.1;
        System.out.println("Сумма: " + sum);
        System.out.println("sum == 1.0 : " + (sum == 1.0)); // false
    }

    private void demonstrateEpsilonComparison() {
        System.out.println("\n Сравнение с epsilon ");
        double a = 0.1 * 10;
        double b = 1.0;
        System.out.println("Корректное сравнение: " + isEquals(a, b, 1e-9));
    }

    private boolean isEquals(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }

    private void demonstrateSpecialValues() {
        System.out.println("\n Специальные значения ");
        double posInf = 1.0 / 0.0;
        double negInf = -1.0 / 0.0;
        double nan = 0.0 / 0.0;
        System.out.println("Infinity: " + posInf);
        System.out.println("-Infinity: " + negInf);
        System.out.println("NaN: " + nan);
        System.out.println("NaN != NaN : " + (nan != nan)); // true
    }

    private void demonstrateRounding() {
        System.out.println("\n Округление ");
        double pos = 2.7, neg = -2.7;
        System.out.println("2.7: (int)=" + (int)pos + ", round=" + Math.round(pos) +
                ", floor=" + Math.floor(pos) + ", ceil=" + Math.ceil(pos));
        System.out.println("-2.7: (int)=" + (int)neg + ", round=" + Math.round(neg) +
                ", floor=" + Math.floor(neg) + ", ceil=" + Math.ceil(neg));
    }

    private void demonstrateFloatVsDouble() {
        System.out.println("\n Точность float vs double ");
        System.out.println("float: " + (1.0f / 3.0f));
        System.out.println("double: " + (1.0 / 3.0));
    }
}