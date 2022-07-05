/**
 * Java. Homework #9
 * @author Viktors Soltums
 * @version 5 Jul 2022
 *
 */
/*
Привести реализаицию RubberList к виду, полученному на занятии (<E>).
 */
public class UseRubberList {
    public static void main(String[] args) {
        RubberList<String> rlStr = new RubberList<>();
        System.out.println(rlStr);
        rlStr.add("A");
        rlStr.add("AB");
        rlStr.add("ABC");
        rlStr.add("DEF");
        System.out.println(rlStr);

        for (Object item: rlStr
        ) {
            System.out.print(item + " ");
        }


        RubberList<Float> flStr = new RubberList<>();
        System.out.println(flStr);
        flStr.add(10f);
        flStr.add(3.4f);
        flStr.add(9.6f);
        flStr.add(0.5f);
        System.out.println(flStr);
    }
}