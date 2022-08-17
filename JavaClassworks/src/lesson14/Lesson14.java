package lesson14;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 1. Регулярные выражения
// 2. Исключения

public class Lesson14 {
    public static void main(String[] args)  {
        Pattern pattern = Pattern.compile(".+Java");
        Matcher matcher = pattern.matcher("Hello Java");
        System.out.println(matcher.matches());
        System.out.println(matcher.start());


        String str = "Jon Jonathan Frank Ken Todd";
        System.out.println(str.replaceAll("Jon.*? ", "Eric "));

        String text = "One, two, three!";
        System.out.println(Arrays.toString(text.split("\\W+")));

        System.out.println("\n\n\n ----- \n\n\n");


        double a = 10.0 / 0;
        System.out.println(a);
        System.out.println();

        int[] b = new int[5];
        int c = 0;
        int idx = 6;
        //c = b[idx];
        try {
            c = 10 / c;
            c = b[idx];
        } catch (Exception e) {
            e.printStackTrace();
        }
//        } catch (ArithmeticException | IndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
//        } catch (IndexOutOfBoundsException e) {
//            e.printStackTrace();
//        }
        System.out.println("c = " + c);

        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }


        //Проброс исключения
        try {
            callNullPointException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successful exit");


        System.out.println(Integer.parseInt("a123"));




    }

    static void callNullPointException() throws IOException {
        nullPointerException();
    }

    static void nullPointerException() throws IOException {
        throw new IOException();
    }


}