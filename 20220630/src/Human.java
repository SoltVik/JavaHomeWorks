public class Human implements IActions {
    private final int runLimit;
    private final int jumpLimit;
    private final String className;
    private final int number;
    private static int counter = 1;

    public Human(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        className = getClass().getSimpleName();
        number = counter++;
    }

    @Override
    public String getName() {
        return className + number;
    }

    @Override
    public void run() {
        System.out.println(className + "ran");
    }

    @Override
    public void jump() {
        System.out.println(className + "jumped");
    }

    @Override
    public boolean ran(Obstacle o) {
        int meters = o.getLength();
        boolean past = (meters <= runLimit);
        printResult(className + number, "ran", past, meters, runLimit);
        return past;
    }

    @Override
    public boolean jumped(Obstacle o) {
        int meters = o.getLength();
        boolean past = (meters <= jumpLimit);
        printResult(className + number, "jumped", past, meters, jumpLimit);
        return past;
    }

    @Override
    public String toString() {
        return className + number + " run limit: " + runLimit + ", jump limit: " + jumpLimit;
    }
}