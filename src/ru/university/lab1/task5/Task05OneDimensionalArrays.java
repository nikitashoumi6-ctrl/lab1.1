package ru.university.lab1.task5;
import java.util.Arrays;

public class Task05OneDimensionalArrays {
    public void run() {
        int[] arr = createRandomArray(10);
        printArray("Исходный массив", arr);
        printMinMaxAverage(arr);
        sortAndPrint(arr);
        demonstrateArrayEquality();
    }

    private int[] createRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 100);
        return arr;
    }

    private void printArray(String msg, int[] arr) {
        System.out.println("--- " + msg + " ---");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }

    private void printMinMaxAverage(int[] arr) {
        int min = arr[0], max = arr[0], sum = 0;
        for (int n : arr) {
            if (n < min) min = n;
            if (n > max) max = n;
            sum += n;
        }
        System.out.println("Мин: " + min + ", Макс: " + max + ", Среднее: " + ((double) sum / arr.length));
    }

    private void sortAndPrint(int[] arr) {
        // Алгоритм: Сортировка пузырьком
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                }
            }
        }
        printArray("Отсортированный массив (пузырьком)", arr);
    }

    private void demonstrateArrayEquality() {
        int[] a = {1, 2, 3}, b = {1, 2, 3};
        System.out.println("\n--- Сравнение массивов ---");
        System.out.println("a == b: " + (a == b)); //false, разные ссылки
        System.out.println("a.equals(b): " + a.equals(b)); //false, у массивов equals не переопределён
        System.out.println("Arrays.equals(a, b): " + Arrays.equals(a, b)); //true, сравнивает элементы
    }
}