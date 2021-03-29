package main.java.com.sergeev.task5;

import java.util.function.Function;

/**
 * Task to write a curried function (using lambdas) that accepts four string arguments and concatenated all
 * in one string following the rules:
 * String cases: in the result string, first and second arguments must be in lower cases and third and fourth in upper cases.
 * Order of arguments concatenation: first, third, second, fourth.
 */
public class Task5_2 {

    static Function<String, Function<String, Function<String, Function<String, String>>>> lambda =
            x -> y -> z -> d -> x.toLowerCase() + z.toUpperCase() + y.toLowerCase() + d.toUpperCase();

    public static void main(String[] args) {
        System.out.println(lambda.apply("Jane")
                .apply("me")
                .apply("make")
                .apply("smile"));
    }
}

