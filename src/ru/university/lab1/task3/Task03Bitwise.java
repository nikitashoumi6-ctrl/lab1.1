package ru.university.lab1.task3;

public class Task03Bitwise {
    public void run() {
        demonstrateBitwiseOperators();
        demonstrateShiftDifference();
        demonstrateBitwiseMethods();
        demonstrateSwap();
    }

    private void demonstrateBitwiseOperators() {
        System.out.println(" Побитовые операции ");
        int a = 5, b = 3;
        System.out.println("5 & 3 = " + (a & b));
        System.out.println("5 | 3 = " + (a | b));
        System.out.println("5 ^ 3 = " + (a ^ b));
        System.out.println("~5 = " + (~a));
        System.out.println("5 << 1 = " + (a << 1));
        System.out.println("5 >> 1 = " + (a >> 1));
        System.out.println("5 >>> 1 = " + (a >>> 1));
    }

    private void demonstrateShiftDifference() {
        System.out.println("\n Разница >> и >>> ");
        int neg = -16;
        //>> сохраняет знаковый бит (заполняет 1), >>> заполняет нулями
        System.out.println("-16 >> 2 = " + (neg >> 2));
        System.out.println("-16 >>> 2 = " + (neg >>> 2));
    }

    private void demonstrateBitwiseMethods() {
        System.out.println("\n Побитовые методы ");
        System.out.println("4 чётное: " + isEven(4));
        System.out.println("8 степень двойки: " + isPowerOfTwo(8));
        System.out.println("Единиц в 13 (1101): " + countSetBits(13));
    }

    private boolean isEven(int n) { return (n & 1) == 0; }
    private boolean isPowerOfTwo(int n) { return n > 0 && (n & (n - 1)) == 0; }
    private int countSetBits(int n) {
        int count = 0;
        while (n != 0) { n &= (n - 1); count++; }
        return count;
    }

    private void demonstrateSwap() {
        System.out.println("\n Обмен через XOR ");
        int x = 5, y = 10;
        System.out.println("До: x=" + x + ", y=" + y);
        x = x ^ y; y = x ^ y; x = x ^ y;
        System.out.println("После: x=" + x + ", y=" + y);
    }
}