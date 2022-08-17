package lesson07;

import java.util.Iterator;

public class TestRubberArray {
    public static void main(String[] args) {
        RubberArray ra = new RubberArray(5,10,15);

        ra.addAll(20,25);
        ra.add(30);
        ra.set(2,20);

        System.out.println("Array size " + ra.size() + ": " + ra);
        System.out.println("Maximal value: " + ra.getMax());
        System.out.println("Minimal value: " + ra.getMin());
        System.out.println("Average value: " + ra.average());
        System.out.println("Index outside array return: " + ra.get(12));

        for (Object i : ra) {
            System.out.print(((Integer) i + 1) + " ");
        }

        System.out.println();

        Iterator iterator = ra.iterator();

        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("\n");

        int[] tempArray = {3,3,3,3};
        ra.addAll(1,tempArray);
        ra.add(3,5);
        System.out.println(ra);
        System.out.println(ra.contains(25));
        System.out.println(ra.contains(50));
        System.out.println(ra.contains(3));
    }
}