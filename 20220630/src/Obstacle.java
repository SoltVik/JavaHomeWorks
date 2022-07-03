public abstract class Obstacle {
    private final int length;
    private final String className;
    private final int number;
    private static int counter = 0;

    public Obstacle(int length) {
        this.length = length;
        className = getClass().getSimpleName();
        number = counter++;
    }

    public String getClassName() {
        return className;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return className + number + " length: " + length;
    }
}