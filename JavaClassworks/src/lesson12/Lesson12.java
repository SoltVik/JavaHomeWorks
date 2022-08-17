package lesson12;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Lesson12 {
    public static void main(String[] args) {

        RunLambda runLambda = () -> System.out.println("Hello, lambda");
        runLambda.run();

        runLambda = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.print(i);
            }
        };
        runLambda.run();

        System.out.println("\n");

        ReturnValue value = (a, b) ->  a + b;
        System.out.println(value.exec(3, 3));

        value = (a, b) -> a * b;
        System.out.println(value.exec(3, 3));

        System.out.println("\n");
        BinaryOperator<String> add = (a, b) -> a + b;
        System.out.println(add.apply("2", "2"));

        UnaryOperator<Integer> twice = (a) -> dd(a);
        System.out.println(twice.apply(5));
    }

    static int dd (int a) {
        return a * 2;
    }
}