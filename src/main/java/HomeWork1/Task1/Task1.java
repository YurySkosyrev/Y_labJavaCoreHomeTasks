package HomeWork1.Task1;

import java.util.Scanner;

/**
 * Домашнее задание №1. Задача №1.
 * Заполнить двумерный массив случайными числами.
 * Вывести минимальное, максимальное, среднее значение массива.
 */

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input number of columns:");
        int n = scanner.nextInt();
        System.out.println("Input number of rows:");
        int m = scanner.nextInt();


        Matrix matrix = new Matrix(n,m);
        matrix.print();
        System.out.println("Min value: " + matrix.minValue());
        System.out.println("Max value: " + matrix.maxValue());
        System.out.printf("Avg value %.3f", matrix.avgValue());
    }
}

/**
 * Класс для работы с двумерным массивом.
 */

class Matrix{
    private int[][] matrix;
    private int n;
    private int m;

    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.matrix = new int[n][m];

        Rand rand = new Rand(100);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = rand.getRand();
            }
        }
    }

    public int minValue(){

        int min = matrix[0][0];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    public int maxValue(){

        int max = matrix[0][0];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    public double avgValue(){

        int sum = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                sum += matrix[i][j];
            }
        }

        return (double)sum/(n*m);
    }

    public void print(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.printf("%2d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
}

/**
 * Класс для генерации псевдослучайных чисел.
 */

class Rand{

    private int max;
    private int seed;

    public Rand(int max) {
        this.max = max;
        seed = (int) (System.currentTimeMillis() % max);
    }

    public int getRand() {
        seed = (seed * 32719 + 3) % 32749;
        return seed % max;
    }

}
