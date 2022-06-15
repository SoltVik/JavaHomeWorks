public abstract class Animal implements IAnimal{
    protected String name;
    protected String color;
    protected int age;
    protected int runLimit;
    protected int swimLimit;
    private static int counter;

    Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        counter++;
    }

    static int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }

    public String run(String name, int meters) {
        if (meters < 0) {
            meters *= -1;
        }
        if (meters <= runLimit) {
            return name + " ran " + meters + " meters";
        } else {
            return name + " can run maximal " + runLimit + " meters";
        }
    }

    public String swim(String name, int meters) {
        if (meters < 0) {
            meters *= -1;
        }
        if (meters <= swimLimit) {
            return name + " swam " + meters + " meters";
        } else {
            return name + " can swim maximal " + swimLimit + " meters";
        }
    }

    @Override
    public String toString() {
        return (name + ", " + color + ", " + age);
    }
}