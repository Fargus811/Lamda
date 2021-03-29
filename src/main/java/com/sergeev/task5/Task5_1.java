package main.java.com.sergeev.task5;

import java.util.function.Function;

/**
 * Task to write a curried form of the function f(x, y, z) = x + y * y + z * z * z using lambda expressions.
 */
public class Task5_1 {

    static Function<Double, Function<Double, Function<Double, Double>>> lambda = x -> y -> z -> x + y * y + z * z * z;

    public static void main(String[] args) {
        System.out.println(lambda.apply(5d).apply(4d).apply(3.0));
    }
}
