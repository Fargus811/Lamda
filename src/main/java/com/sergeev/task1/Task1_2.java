package main.java.com.sergeev.task1;

import java.util.function.Function;

/**
 * Task accepts a long value and returns a next even number.
 */
public class Task1_2 {

    public static void main(String[] args) {
        int inputValue = Integer.parseInt(args[0]);
        Task1_2 task1_2 = new Task1_2();
        Function<Integer, Integer> plusOneOrTwo = (x) -> (x % 2 == 0) ? (x + 2) : (x + 1);
        System.out.println(task1_2.process(inputValue, plusOneOrTwo));
    }

    public int process(int a, Function<Integer, Integer> biFunction) {
        return biFunction.apply(a);
    }
}
