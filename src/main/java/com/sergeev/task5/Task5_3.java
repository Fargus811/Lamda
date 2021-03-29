package main.java.com.sergeev.task5;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/**
 * In this task need to complete the implementations of two functions.
 *
 * The reduceIntOperator that accepts an initial value (seed) and a combiner function and returns a new function
 * that combines all values from the given integer range into a single integer value (it's a simple form of reduction)
 * using a given operator. The seed is used as the very first element in reducing.
 * Based on reduceIntOperator, implement the productOperator operator that multiplies integer values in the range.
 */
public class Task5_3 {

    public static void main(String[] args) {
        System.out.println("Sum: " + sumOperator.applyAsInt(1, 4));
        System.out.println("Sum negative: " + sumOperator.applyAsInt(-3, 0));
        System.out.println("Sum zero: " + sumOperator.applyAsInt(0, 4));
        System.out.println("Sum same: " + sumOperator.applyAsInt(4, 4));
        System.out.println("Sum zeros: " + sumOperator.applyAsInt(0, 0));

        System.out.println("Product: " + productOperator.applyAsInt(1, 4));
        System.out.println("Product negative: " + productOperator.applyAsInt(-3, -1));
        System.out.println("Product zero: " + productOperator.applyAsInt(0, 4));
        System.out.println("Product same: " + productOperator.applyAsInt(4, 4));
        System.out.println("Product zeros: " + productOperator.applyAsInt(0, 0));
    }
    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            (seed, operator) -> (leftBoundary, rightBoundary) -> IntStream.rangeClosed(leftBoundary, rightBoundary)
                    .reduce(seed, operator);

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator = reduceIntOperator.apply(0, Integer::sum);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator = reduceIntOperator.apply(1, (x, y) -> x * y);
}
