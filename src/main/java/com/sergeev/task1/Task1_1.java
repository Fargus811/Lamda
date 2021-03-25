package main.java.com.sergeev.task1;

import java.util.function.BiFunction;

/**
 * Task to compares two numbers and shows more.
 */
public class Task1_1 {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Task1_1 task1 = new Task1_1();
        BiFunction<Integer, Integer, Integer> comparing = (a, b) -> a > b ? a : b;
        System.out.println(task1.process(x, y, comparing));
    }

    public int process(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }
}

