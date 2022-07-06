public class Treadmill implements IObstacle {

    private final int length;
    private final String className;
    private final int number;
    private static int counter = 0;

    public Treadmill(int length) {
        this.length = length;
        className = getClass().getSimpleName();
        number = counter++;
    }

    @Override
    public boolean exec(IActions member){
        return member.run(length, className);
    }

    @Override
    public String toString() {
        return className + number + " length: " + length;
    }
}
