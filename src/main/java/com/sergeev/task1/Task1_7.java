package main.java.com.sergeev.task1;

import java.util.function.Function;

/**
 * Task adds prefix (before) and suffix (after) to its single string argument; prefix and suffix are final variables.
 */
public class Task1_7 {

    private static final String PREFIX = "hello";
    private static final String SUFFIX = "world";

    public static void main(String[] args) {
        Task1_7 task1_7 = new Task1_7();
        Function<String, String> function = s -> PREFIX.concat(s.trim()).concat(SUFFIX);
        System.out.println(task1_7.process(args[0], function));
    }

    public String process(String inputValue, Function<String, String> function) {
        return function.apply(inputValue);
    }
}
