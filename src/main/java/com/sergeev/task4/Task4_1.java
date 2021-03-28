package main.java.com.sergeev.task4;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a collector that evaluates the product of squares of integer numbers in a Stream<Integer>.
 */
public class Task4_1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 1, 2);
        long val = numbers.stream().collect(Collectors.reducing(1l, Integer::longValue, (a, b) -> a * (b * b)));
        System.out.println(val);
    }
}
