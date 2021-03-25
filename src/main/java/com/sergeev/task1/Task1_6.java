package main.java.com.sergeev.task1;

import java.util.function.Function;

/**
 * Task calculates a*x^2 + b*x + c where a, b, c are context final variables, The result is double.
 */
public class Task1_6 {

    private static final long A_VARIABLE = 5;
    private static final long B_VARIABLE = 6;
    private static final long C_VARIABLE = 7;

    public static void main(String[] args) {
        double inputValue = Double.parseDouble(args[0]);
        Task1_6 task1_6 = new Task1_6();
        Function<Double, Double> function = (x) -> (Double) (A_VARIABLE * x * x + B_VARIABLE * x + C_VARIABLE);
        System.out.println(task1_6.process(inputValue, function));
    }

    public Double process(double inputValue, Function<Double, Double> function) {
        return function.apply(inputValue);
    }
}
