public class Dog extends Animal {
    private static int counter;

    public Dog(int runLimit, int swimLimit) {
        super(runLimit, swimLimit);
        counter++;
    }

    static int getCounter() {
        return counter;
    }

}
