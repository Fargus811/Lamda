package main.java.com.sergeev.task2;

/**
 * Task return true if all passed values are different otherwise false.
 */
public class Task2_2 {
    @FunctionalInterface
    interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
    }

    private static final TernaryIntPredicate allValuesAreDifferentPredicate = (x, y, z) -> x != y && x != z && y != z;

    public static void main(String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(1, 1, 1)); //false result
        System.out.println(allValuesAreDifferentPredicate.test(1, 2, 3)); //true result
    }
}
