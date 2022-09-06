package HomeWork2.Task3;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Домашнее задание №2. Задача №3.
 * Реализовать функцию нечёткого поиска
 */

public class Task3 {
    public static void main(String[] args) {

        String expression = "car";
        String text = "ca6$$#_rtwheel";

        System.out.println("fuzzySearch(\"" + expression + "\", \"" + text + "\") -> " +
                fuzzySearch(expression,text));

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    static boolean fuzzySearch(String expression, String text){
        Queue<Character> sampleQueue = new ArrayDeque<>();

        for (Character c : expression.toCharArray()){
            sampleQueue.offer(c);
        }

        for (Character c : text.toCharArray()){
            if(!sampleQueue.isEmpty() && c == sampleQueue.element()){ sampleQueue.remove();}
        }

        return sampleQueue.isEmpty();
    }

    static void test1(){
        assert fuzzySearch("car", "ca6$$#_rtwheel")  : "Test1 wrong answer";
    }

    static void test2(){
        assert fuzzySearch("cwhl", "cartwheel") : "Test2 wrong answer";
    }

    static void test3(){
        assert fuzzySearch("cwhee", "cartwheel") : "Test3 wrong answer";
    }

    static void test4(){
        assert fuzzySearch("cartwheel", "cartwheel") : "Test4 wrong answer";
    }

    static void test5(){
        assert !fuzzySearch("cwheeel", "cartwheel") : "Test5 wrong answer"; // false
    }

    static void test6(){
        assert !fuzzySearch("lw", "cartwheel") : "Test6 wrong answer"; // false
    }
}
