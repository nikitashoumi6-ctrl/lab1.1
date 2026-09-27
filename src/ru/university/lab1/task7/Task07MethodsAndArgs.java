package ru.university.lab1.task7;

public class Task07MethodsAndArgs {
    public void run() {
        demonstrateOverload();
        demonstrateVarargs();
        demonstratePower();
    }

    private void demonstrateOverload() {
        System.out.println(" Перегрузка методов ");
        print(5); print(3.14); print("Hello"); print(new int[]{1, 2, 3});
    }

    private void print(int n) { System.out.println("int: " + n); }
    private void print(double d) { System.out.println("double: " + d); }
    private void print(String s) { System.out.println("String: " + s); }
    private void print(int[] arr) {
        System.out.print("int[]: ");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    private void demonstrateVarargs() {
        System.out.println("\n Varargs ");
        System.out.println("Сумма (без аргументов): " + sum());
        System.out.println("Сумма (1, 2, 3): " + sum(1, 2, 3));
        System.out.println("Сумма (массив): " + sum(new int[]{4, 5, 6}));
    }

    private int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    private void demonstratePower() {
        System.out.println("\n Возведение в степень ");
        int base = 2, exp = 10;
        System.out.println(base + "^" + exp + " (рекурсивно): " + powerRecursive(base, exp));
        System.out.println(base + "^" + exp + " (итеративно): " + powerIterative(base, exp));
        System.out.println("Math.pow: " + (int)Math.pow(base, exp));
    }

    private int powerRecursive(int base, int exp) {
        if (exp == 0) return 1;
        return base * powerRecursive(base, exp - 1);
    }

    private int powerIterative(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }
}