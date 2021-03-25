package main.java.com.sergeev.task1;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Task accepts a list of strings and returns new list of distinct strings (without repeating).
 */
public class Task1_5 {

    public static void main(String[] args) {
        Task1_5 task1_5 = new Task1_5();
        Function<List<String>, String> function = (x) -> x.stream().distinct().collect(Collectors.joining());
        System.out.println(task1_5.process(List.of(args), function));
    }

    public String process(List<String> lineToFormat, Function<List<String>, String> uniqueFunction) {
        return uniqueFunction.apply(lineToFormat);
    }
}
