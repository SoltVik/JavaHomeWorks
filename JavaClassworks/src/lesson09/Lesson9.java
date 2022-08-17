package lesson09;

public class Lesson9 {
    public static void main(String[] args) {
        RubberArray<Integer> ra = new RubberArray(5,25);
        ra.addAll(1,30);
        ra.add(6);
        System.out.println(ra);

        System.out.println("\n---------\n");

        RubberList rl = new RubberList();
        rl.offer(1);
        rl.offer(2);
        rl.offer(51);
        //rl.push(123);

        System.out.println(rl);

        for (Object item : rl) {
            System.out.println(item);
        }

        //rl.remove(3);
        System.out.println("poll: " + rl.poll());
        System.out.println("poll: " + rl.poll());
        System.out.println("peek: " + rl.peek());
        System.out.println("pop: " + rl.pop());
        System.out.println("pop: " + rl.pop());

        System.out.println(rl);



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


    }
}


