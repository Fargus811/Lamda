package main.java.com.sergeev.task3;

import java.util.stream.IntStream;

/**
 * Description: The first stream contains even numbers and the second stream contains odd numbers.
 * Create the third stream that contains numbers from both streams which is divisible by 3 and 5.
 */
public class Task3_3 {

    public static void main(String[] args) {
        IntStream evenStream = IntStream.of(1, 2, 3, 4);
        IntStream oddStream = IntStream.of(30, 75, 60, 90);

        createFilteringStream(evenStream, oddStream).forEach(System.out::println);
    }

    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream).filter(x -> x % 3 == 0 && x % 5 == 0).sorted().skip(2);
    }
}
