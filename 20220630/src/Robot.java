public class Robot implements IActions {
    private final int runLimit;
    private final int jumpLimit;
    private final String className;
    private final int number;
    private static int counter = 1;

    public Robot(int runLimit, int jumpLimit) {
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
    public boolean run(int length) {
        boolean past = (length <= runLimit);
        printResult(className + number, "ran", past, length, runLimit);
        return past;
    }

    @Override
    public boolean jump(int height) {
        boolean past = (height <= jumpLimit);
        printResult(className + number, "jumped", past, height, jumpLimit);
        return past;
    }

    @Override
    public String toString() {
        return className + number + " run limit: " + runLimit + ", jump limit: " + jumpLimit;
    }
}