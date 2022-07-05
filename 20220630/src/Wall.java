public class Wall implements IObstacle {

    private final int height;
    private final String className;
    private final int number;
    private static int counter = 0;

    public Wall(int length) {
        this.height = length;
        className = getClass().getSimpleName();
        number = counter++;
    }

    @Override
    public boolean exec(IActions member){
        return member.jump(height);
    }

    @Override
    public String toString() {
        return className + number + " height: " + height;
    }



}
