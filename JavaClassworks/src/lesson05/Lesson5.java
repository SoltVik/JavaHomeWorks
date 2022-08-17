package lesson05;

public class Lesson5 {
    public static void main(String[] args) {
        Zero zero = new Zero();
        Zero zero1 = new Zero();
        zero = zero1;
        System.out.println(zero.n);

        String s1 = new String("Hello");
        String s2 = new String("Hello");

        if (s1.equals(s2)) {
            System.out.println("Equal");
        } else {
            System.out.println("NOT Equal");
        }




        int a = 4;
        int b = 8;
        a = b;
        if (a == b) {
            // TODO
        }


        System.out.println("\n\n\n\n");

        RubberArray ra = new RubberArray();
        ra.add(5);
        ra.add(10);
        ra.add(15);
        ra.add(25);
        System.out.println("dsa: " + ra.get(12));


        System.out.println(ra.size() + ": " + ra);
        ra.remove(1);
        System.out.println(ra);
        ra.remove(2);
        System.out.println(ra);
        ra.remove(0);
        System.out.println(ra);
        ra.remove(0);
        System.out.println(ra);
        ra.add(9);
        System.out.println(ra);


    }
}
