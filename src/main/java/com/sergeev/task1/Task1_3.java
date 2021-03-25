package main.java.com.sergeev.task1;

import java.util.function.Function;

/**
 * Task  accepts seven string arguments and returns a string in upper case concatenated from all of them.
 */
public class Task1_3 {

    interface Concatenation<S> {
        String concat(String firstWord, String secondWord, String thirdWord, String fourthWord, String fifthWord,
                      String sixthWord, String seventhWord);
    }

    public static void main(String[] args) {
        Task1_3 task1_3 = new Task1_3();
        Concatenation<String> concatenation = (a, b, c, d, e, f, g) -> a.toUpperCase() + b.toUpperCase() +
                c.toUpperCase() + d.toUpperCase() + e.toUpperCase() + f.toUpperCase() + g.toUpperCase();
        System.out.println(task1_3.process(args[0],args[1],args[2],args[3],args[4],args[5],args[6], concatenation));
    }

    public String process( String firstWord, String secondWord, String thirdWord, String fourthWord, String fifthWord,
                        String sixthWord, String seventhWord, Concatenation<String> stringConcatenation) {
        return stringConcatenation.concat(firstWord,secondWord,thirdWord,fourthWord,fifthWord,sixthWord,seventhWord);
    }
}
