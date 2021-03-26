package main.java.com.sergeev.task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Task detects bad words in a text according to a bad words list.
 * All words in the text are divided by whitespaces (always only one whitespace between two words).
 */
public class Task3_2 {

    public static void main(String[] args) {
        String text = "i will f your a and you will s my d you curseWord1 a";
        List<String> badWords = Arrays.asList("curseWord1", "curseWord2", "f", "d", "a", "s", "c");
        createBadWordsDetectingStream(text, badWords).forEach(System.out::println);
    }

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split(" ")).distinct().filter(t -> badWords.contains(t)).sorted();
    }
}
