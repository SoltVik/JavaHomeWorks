public class Road implements Stage {
    protected int length;
    protected String description;
    private Object monitor = new Object();

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);

            synchronized (monitor) {
                c.checkWinner();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}