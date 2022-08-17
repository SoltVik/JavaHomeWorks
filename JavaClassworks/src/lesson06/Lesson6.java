package lesson06;

import java.util.*;

//JCF. Java Collections Framework
public class Lesson6 {
    public static void main(String[] args) {
        Set<String> list = new HashSet<>();
        System.out.println(list.addAll(Arrays.asList("A","B","C")));
        System.out.println(list.add("B"));
        System.out.println(list);

        System.out.println();

        Map<Integer,String> map = new HashMap<>();
        map.put(1, "one");
        map.put(3, "three");
        map.put(2, "two");
        System.out.println(map);
        System.out.println("2 is " + map.get(2));
    }
}