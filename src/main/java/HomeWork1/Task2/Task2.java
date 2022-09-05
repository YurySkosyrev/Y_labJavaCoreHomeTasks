package HomeWork1.Task2;

import java.util.Arrays;

/**
 * Домашнее задание №1. Задача №2.
 * Отсортировать массив [5,6,3,2,5,1,4,9].
 * Написать простые тесты.
 * Учесть дубликаты.
 */

public class Task2 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,6,3,2,5,1,4,9};
        int[] duplicateArr = new int[]{6,2,2,1,5,5,6,9};

        System.out.println("Unsorted array: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted array by bubble sort: " + Arrays.toString(arr));
        test(arr, new int[]{1,2,3,4,5,5,6,9});

    }

    static void bubbleSort(int[] arr){
        for(int i = arr.length -1; i >= 0; i--){
            for (int j = 0; j < i; j ++){
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        assert isSorted(arr);
    }

    static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                return false;
        return true;
    }

    static void test(int[] x, int[] y){
        assert Arrays.equals(x,y);
    }
}
