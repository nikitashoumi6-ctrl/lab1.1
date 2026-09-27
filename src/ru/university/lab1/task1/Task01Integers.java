package ru.university.lab1.task1;

public class Task01Integers {
    public void run() {
        printMinMax();
        demonstrateMaxValuePlusOne();
        demonstrateMaxValueTimesTwo();
        demonstrateDivisionAndModulo();
        demonstrateLongToIntCast();
        demonstrateCharArithmetic();
        demonstrateOverflowCheck();
    }

    private void printMinMax() {
        System.out.println(" Мин/Макс значения ");
        System.out.println("byte: " + Byte.MIN_VALUE + " ... " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.MIN_VALUE + " ... " + Short.MAX_VALUE);
        System.out.println("int: " + Integer.MIN_VALUE + " ... " + Integer.MAX_VALUE);
        System.out.println("long: " + Long.MIN_VALUE + " ... " + Long.MAX_VALUE);
    }

    private void demonstrateMaxValuePlusOne() {
        System.out.println("\n Integer.MAX_VALUE + 1 ");
        int max = Integer.MAX_VALUE;
        int result = max + 1;
        //переполнение: при добавлении 1 к максимальному значению int,
        //биты переполняются и число становится минимальным отрицательным
        System.out.println("Результат: " + result);
    }

    private void demonstrateMaxValueTimesTwo() {
        System.out.println("\n Integer.MAX_VALUE * 2 ");
        int max = Integer.MAX_VALUE;
        int resultInt = max * 2;
        long resultLong = (long) max * 2;
        //в int происходит переполнение и потеря старших битов (результат -2)
        //в long приведение происходит до умножения, поэтому переполнения нет
        System.out.println("В int: " + resultInt);
        System.out.println("В long: " + resultLong);
    }

    private void demonstrateDivisionAndModulo() {
        System.out.println("\n Деление и остаток ");
        //знак остатка всегда совпадает со знаком делимого
        System.out.println("5 / 2 = " + (5 / 2));
        System.out.println("-5 / 2 = " + (-5 / 2));
        System.out.println("5 % 2 = " + (5 % 2));
        System.out.println("-5 % 2 = " + (-5 % 2));
    }

    private void demonstrateLongToIntCast() {
        System.out.println("\n--- Приведение long к int ---");
        long largeLong = (long) Integer.MAX_VALUE + 100;
        int castedToInt = (int) largeLong;
        //при приведении long к int отбрасываются старшие 32 бита
        System.out.println("long: " + largeLong + ", после приведения к int: " + castedToInt);
    }

    private void demonstrateCharArithmetic() {
        System.out.println("\n Арифметика char ");
        char a = 'A';
        char next = (char) (a + 1);
        char b = 'B';
        int sum = a + b;
        System.out.println("Следующая буква после 'A': " + next);
        System.out.println("Сумма 'A' + 'B' как число: " + sum);
        System.out.println("Сумма 'A' + 'B' как символ: " + (char) sum);
    }

    private void demonstrateOverflowCheck() {
        System.out.println("\n Проверка переполнения при сложении ");
        System.out.println("Сложение MAX_VALUE и 1, переполнение: " + hasOverflow(Integer.MAX_VALUE, 1));
        System.out.println("Сложение 10 и 20, переполнение: " + hasOverflow(10, 20));
    }

    private boolean hasOverflow(int a, int b) {
        int result = a + b;
        //переполнение, если знаки операндов совпадают, а знак результата отличается
        return ((a > 0 && b > 0 && result < 0) || (a < 0 && b < 0 && result > 0));
    }
}
