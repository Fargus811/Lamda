package main.java.com.sergeev.task2;

import java.util.List;
import java.util.function.IntPredicate;

public class Task2_3 {

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        return predicates.stream().reduce(x -> false, IntPredicate::or);
    }
}
