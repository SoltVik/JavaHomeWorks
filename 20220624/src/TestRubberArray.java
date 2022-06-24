/**
 * Java. Homework #5
 * @author Viktors Soltums
 * @version 24 Jun 2022
 *
 */
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
    }
}