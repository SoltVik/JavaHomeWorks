/**
 * Java. Homework #4
 * @author Viktors Soltums
 * @version 21 Jun 2022
 *
 */
/*
Дополнить код, написанный на занятии:
Добавить методы getMax(), getMin() и average()
Исправить метод get() чтобы он возвращал null если индекс выходит за границы массива (необязательно)
*/
public class TestRubberArray {
    public static void main(String[] args) {
        RubberArray ra = new RubberArray();

        ra.add(25);
        ra.add(15);
        ra.add(10);
        ra.add(25);

        System.out.println("Array size " + ra.size() + ": " + ra);
        System.out.println("Maximal value: " + ra.getMax());
        System.out.println("Minimal value: " + ra.getMin());
        System.out.println("Average value: " + ra.average());
        System.out.println("Index outside array return: " + ra.get(12));

        System.out.println("\n");
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