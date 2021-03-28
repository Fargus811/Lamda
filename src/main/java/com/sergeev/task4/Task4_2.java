package main.java.com.sergeev.task4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Task with collector that partitions all words in a stream into two groups: palindromes (true) and usual words (false).
 */
public class Task4_2 {

    public static void main(String[] args) {
        String[] words = {"level", "bbaa", "ac"};
        Map<Boolean, List<String>> palindromeOrNoMap =
                Arrays.stream(words)
                        .collect(Collectors.partitioningBy(s -> s.contentEquals(new StringBuffer(s).reverse())));
        palindromeOrNoMap.entrySet().forEach(System.out::println);
    }
}
