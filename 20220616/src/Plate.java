public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int food) {
        if (this.food >= food) {
            this.food -= food;
            return true;
        }
        return false;
    }

    public void addFood(int food) {
        if (food > 0) {
            this.food += food;
        }
    }

    public int getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}
