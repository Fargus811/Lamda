package main.java.com.sergeev.task1;

import java.util.stream.LongStream;

/**
 * Task accepts two long arguments as a range borders and calculates (returns) production of all numbers in this range.
 */
public class Task1_4 {

    interface Calculator {
        long calculateProductionOfNumbersInRange(long startRange, long endRange);
    }

    public static void main(String[] args) {
        long firstNumber = Long.parseLong(args[0]);
        long secondNumber = Long.parseLong(args[1]);
        Task1_4 task1_4 = new Task1_4();
        Calculator calculator = (a, b) -> LongStream.rangeClosed(a, b).boxed().reduce(1L, (x, y) -> x * y);
        System.out.println(task1_4.process(firstNumber, secondNumber, calculator));
    }

    public long process(long firstNumber, long secondNumber, Calculator calculator) {
        return calculator.calculateProductionOfNumbersInRange(firstNumber, secondNumber);
    }
}
