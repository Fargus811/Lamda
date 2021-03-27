package main.java.com.sergeev.task3;

import java.util.stream.LongStream;

/**
 * Task calculates factorial of given number. For a example "5".
 */
public class Task3_4 {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static long factorial(long number) {
        return LongStream.rangeClosed(2, number)
                .reduce(1, (x, y) -> x * y);
    }
}
