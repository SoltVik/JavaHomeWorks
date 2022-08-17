package lesson04;

public class Cat {
    private final String name;
    private final int appetit;

    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(appetit);
    }

    @Override
    public String toString() {
        return "Cat: " + name + ", appetite: " + appetit;
    }
}
