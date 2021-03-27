package main.java.com.sergeev.task3;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Task should check is the input value is prime number.
 */
public class Task3_1 {

    public static void main(String[] args) {
        System.out.println(isPrime(3));
    }

    public static boolean isPrime(final long number) {
        return number > 1 && LongStream.range(2, number).noneMatch(i -> number % i == 0);
    }
}
