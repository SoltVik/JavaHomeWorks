public class Dog extends Animal {
    private static int counter;

    public Dog(String name, String color, int age) {
        super(name, color, age);
        runLimit = 500;
        swimLimit = 10;
        counter++;
    }


    @Override
    public String voice() {
        return "Gaf-Gaf!";
    }

    @Override
    public String run(int meters) {
        if (meters < 0) {
            meters *= -1;
        }
        if (meters <= runLimit) {
            return "Dog hat ran " + meters + " meters.";
        } else {
            return "Dog can run maximal " + runLimit + " meters.";
        }
    }

    @Override
    public String swim(int meters) {
        if (meters < 0) {
            meters *= -1;
        }
        if (meters <= swimLimit) {
            return "Dog swam " + meters + " meters";
        } else {
            return "Dog can swim maximal " + swimLimit + " meters";
        }
    }

    static int getCounter() {
        return counter;
    }

}
