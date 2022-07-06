public class Cat implements IActions {
    private final int runLimit;
    private final int jumpLimit;
    private final String className;
    private final int number;
    private static int counter = 1;

    public Cat(int runLimit, int jumpLimit) {
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
    public boolean run(int length, String obstacle) {
        boolean past = (length <= runLimit);
        printResult(className + number, new String[]{"run", "ran", "length"}, past, obstacle, length, runLimit);
        return past;
    }

    @Override
    public boolean jump(int height, String obstacle) {
        boolean past = (height <= jumpLimit);
        printResult(className + number, new String[]{"jump", "jumped", "height"}, past, obstacle, height, jumpLimit);
        return past;
    }

    @Override
    public String toString() {
        return className + number + " run limit: " + runLimit + ", jump limit: " + jumpLimit;
    }
}