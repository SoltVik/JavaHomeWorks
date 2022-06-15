public class Cat extends Animal{
    private static int counter;

    Cat(String name, String color, int age) {
        super(name, color, age);
        runLimit = 200;
        swimLimit = 0;
        counter++;
    }

    @Override
    public String voice() {
        return "Meow!";
    }

    @Override
    public String run(int meters) {
        if (meters < 0) {
            meters *= -1;
        }
        if (meters <= runLimit) {
            return "Cat ran " + meters + " meters";
        } else {
            return "Cat can run maximal " + runLimit + " meters";
        }
    }

    @Override
    public String swim(int meters) {
        return "Cat can't swim";
    }

    @Override
    public String swim(String name, int meters) {
        return name + " can't swim";
    }

    static int getCounter() {
        return counter;
    }
}
