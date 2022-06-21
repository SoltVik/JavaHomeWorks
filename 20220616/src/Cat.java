public class Cat {
    private final String name;
    private final int appetit;
    private boolean hungry = true;

    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }

    public boolean eat(Plate plate) {
        if (hungry) {
            hungry = !(plate.decreaseFood(appetit));
            return !(hungry);
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean isHungry() {
        return hungry;
    }

    public int getAppetit() {
        return appetit;
    }

    @Override
    public String toString() {
        return "Cat: " + name + ", appetite: " + appetit;
    }
}
