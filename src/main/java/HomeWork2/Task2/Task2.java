package HomeWork2.Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Домашнее задание №2. Задача №2.
 *  [3, 4, 2, 7], 10 -> [3, 7] - вывести пару именно в скобках, которые дают сумму - 10
 */

public class Task2 {
    public static void main(String[] args) {

        int[] nums = new int[]{3, 4, 2, 7};

        System.out.println(findPairs(nums,10));

        test1();
        test2();
        test3();

    }

    /**
     * сложность алгоритма O(n)
     * Вывод в виде String для более красивой печати и тестирования
     */

    public static String findPairs(int[] arr, int sum){

        String result = "";
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            if (hashMap.containsKey(sum - arr[i])){
                result += String.format("[%d, %d]",
                        arr[hashMap.get(sum - arr[i])], arr[i]);
                return result;
            }

            hashMap.put(arr[i], i);

        }

        return result;
    }

    static void test1(){
        assert "[3, 7]".equals(findPairs(new int[]{3, 4, 2, 7},10)) : "Test1 wrong answer";
    }

    static void test2(){
        assert "".equals(findPairs(new int[]{11, 4, 2, 7},10)) : "Test2 wrong answer";
    }

    static void test3(){
        assert "".equals(findPairs(new int[]{},10)) : "Test3 wrong answer";
    }
}
