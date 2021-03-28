package main.java.com.sergeev.task4;

import java.util.stream.LongStream;

/**
 * Task to create a parallel LongStream for filtering prime numbers in the given range (inclusively).
 */
public class Task4_5 {

    public static void main(String[] args) {
        createPrimesFilteringStream(1, 7).forEach(System.out::println);
    }

    public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
        return LongStream.rangeClosed(rangeBegin, rangeEnd)
                .parallel()
                .filter(number -> number > 1 && LongStream.range(2, number).noneMatch(i -> number % i == 0));
    }
}
