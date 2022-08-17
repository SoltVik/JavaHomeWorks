package lesson08;
import org.w3c.dom.Node;

public class Lesson8 {
    public static void main(String[] args) {

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


    }
}