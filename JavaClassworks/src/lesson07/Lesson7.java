package lesson07;

public class Lesson7 {
    public static void main(String[] args) {
        SimpleBox box1 = new SimpleBox(5);
        SimpleBox box2 = new SimpleBox(6);

        if (box1.getObj() instanceof Integer && box2.getObj() instanceof Integer) {
            System.out.println((Integer) box1.getObj() + (Integer) box2.getObj());
        }

        //box1.setObj("Hello");
        //box2.setObj(" Java");

        //System.out.println("" + box1.getObj() + box2.getObj());
        System.out.println();


        SimpleBox<Integer> box3 = new SimpleBox<>(5);
        SimpleBox<Integer> box4 = new SimpleBox<>(6);

        System.out.println(box3.getObj() + box4.getObj());
        System.out.println(box3.getType());

        SimpleBox<Float> box5 = new SimpleBox<>(3.5f);
        SimpleBox<Float> box6 = new SimpleBox<>(4.8f);
        System.out.println(box5.getObj() + box6.getObj());
        System.out.println(box5.getType());
    }
}


