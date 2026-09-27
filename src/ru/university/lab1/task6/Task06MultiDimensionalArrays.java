package ru.university.lab1.task6;

public class Task06MultiDimensionalArrays {
    public void run() {
        int[][] matrix = createAndPrintMatrix(3, 4);
        printMatrix("Транспонированная матрица", transpose(matrix));

        int[][] m1 = {{1, 2}, {3, 4}};
        int[][] m2 = {{5, 6}, {7, 8}};
        int[][] multiplied = multiplyMatrices(m1, m2);
        if (multiplied != null) printMatrix("Результат умножения", multiplied);
    }

    private int[][] createAndPrintMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int counter = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) matrix[i][j] = counter++;
        }
        printMatrix("Исходная матрица " + m + "x" + n, matrix);
        return matrix;
    }

    private void printMatrix(String msg, int[][] matrix) {
        System.out.println("--- " + msg + " ---");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) System.out.printf("%4d", matrix[i][j]);
            System.out.println();
        }
    }

    private int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) result[j][i] = matrix[i][j];
        }
        return result;
    }

    private int[][] multiplyMatrices(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            System.out.println("Ошибка");
            return null;
        }
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) result[i][j] += a[i][k] * b[k][j];
            }
        }
        return result;
    }
}