package main.java.com.sergeev.task3;

import java.util.stream.LongStream;

/**
 * Task calculates the sum of odd numbers in the given interval (inclusively).
 */
public class Task3_5 {

    public static void main(String[] args) {
        System.out.println(sumOfOddNumbersInRange(1l, 3l));
    }

    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .filter(x -> x % 2 != 0)
                .reduce(0, Long::sum);
    }
}
