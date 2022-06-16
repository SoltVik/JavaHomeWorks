public abstract class Animal implements IAnimal{
    protected int runLimit;
    protected int swimLimit;
    protected String className;
    private static int counter = 0;

    Animal(int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        className = getClass().getSimpleName();
        counter++;
    }

    static int getCounter() {
        return counter;
    }

    public String getClassName() {
        return className;
    }

    public String run(int meters) {
        if (meters < 0) {
            meters *= -1;
        }
        if (meters <= runLimit) {
            return className + " ran " + meters + " meters";
        } else {
            return className + " can run maximal " + runLimit + " meters";
        }
    }

    public String swim(int meters) {
        if (meters < 0) {
            meters *= -1;
        }
        if (meters <= swimLimit) {
            return className + " swam " + meters + " meters";
        } else {
            return className + " can swim maximal " + swimLimit + " meters";
        }
    }

    @Override
    public String toString() {
        return (className + ". Run limit: " + runLimit + ". Swim  limit: " + swimLimit);
    }
}