public class Cat extends Animal{
    private static int counter;

    Cat(int runLimit) {
        super(runLimit, 0);
        counter++;
    }

    @Override
    public String swim(int meters) {
        return  getClassName() + " can't swim";
    }

    static int getCounter() {
        return counter;
    }
}
