package lesson18;

public class Counter {
    private int value;

    private Object monitorValue = new Object(); //POJO


    public Counter() {
        this.value = 0;
    }

    public void increment() {
        synchronized (monitorValue) {
            value++;
        }
        // Some Code
    }

    public void decrement() {
        synchronized (monitorValue) {
            value--;
        }
        // Some Code
    }

    @Override
    public String toString() {
        return "Counter{" +
                "value=" + value +
                '}';
    }
}
