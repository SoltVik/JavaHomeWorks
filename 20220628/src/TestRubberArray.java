/**
 * Java. Homework #6
 * @author Viktors Soltums
 * @version 28 Jun 2022
 *
 */
public class TestRubberArray {
    public static void main(String[] args) {
        RubberArray<Integer> ra = new RubberArray<>(5,10,15);

        ra.addAll(2,25);
        ra.add(30);
        ra.set(2,20);

        System.out.println("Array size " + ra.size() + ": " + ra);
        System.out.println("Index outside array return: " + ra.get(12));

        for (Object i : ra) {
            System.out.print(((Integer) i + 1) + " ");
        }

        System.out.println("\n");

        Integer[] tempArray = {3,3,3,3};
        ra.addAll(1,tempArray);
        ra.add(3,5);
        System.out.println(ra);
        System.out.println(ra.contains(25));
        System.out.println(ra.contains(50));
        System.out.println(ra.contains(3) + "\n\n ");


        RubberArray<String> ra2 = new RubberArray<>("A", "B", "C");
        ra2.addAll(2, "D");
        ra2.set(1,"E");

        String[] tempArray1 = {"F","G","H"};
        ra2.addAll(1,tempArray1);
        System.out.println(ra2);
        System.out.println(ra2.contains("X"));


        RubberArray<Float> ra3 = new RubberArray<>(2.5f, 3.8f, 4.3f);
        ra3.addAll(2, 3.3f);
        ra3.set(1,2.3f);

        Float[] tempArray2 = {1f,0.5f,6.3f};
        ra3.addAll(1,tempArray2);
        System.out.println(ra3);
        System.out.println(ra3.contains(0.5f));
    }
}