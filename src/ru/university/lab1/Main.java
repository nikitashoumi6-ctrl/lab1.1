package ru.university.lab1;

import java.util.Scanner;
import ru.university.lab1.task1.Task01Integers;
import ru.university.lab1.task2.Task02FloatingPoint;
import ru.university.lab1.task3.Task03Bitwise;
import ru.university.lab1.task4.Task04TextProcessing;
import ru.university.lab1.task5.Task05OneDimensionalArrays;
import ru.university.lab1.task6.Task06MultiDimensionalArrays;
import ru.university.lab1.task7.Task07MethodsAndArgs;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        String helpText = """
                Доступные задания:
                1 - Целочисленные ловушки
                2 - Вещественная арифметика
                3 - Побитовые операции
                4 - Обработка текста
                5 - Одномерные массивы
                6 - Многомерные массивы
                7 - Методы и передача аргументов
                8 - Выход
                """;
        System.out.println(helpText);

        do {
            System.out.print("Введите № задания: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка. Не то число, заново ввод");
                scanner.next(); // очистка буфера
                continue;
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> new Task01Integers().run();
                case 2 -> new Task02FloatingPoint().run();
                case 3 -> new Task03Bitwise().run();
                case 4 -> new Task04TextProcessing().run();
                case 5 -> new Task05OneDimensionalArrays().run();
                case 6 -> new Task06MultiDimensionalArrays().run();
                case 7 -> new Task07MethodsAndArgs().run();
                case 8 -> {
                    System.out.println("Выход из программы.");
                    exit = true;
                }
                default -> System.out.println("Ошибка, попробуйте снова");
            }
        } while (!exit);

        scanner.close();
    }
}