import java.util.Arrays;

public class RubberArray {
    private int [] array = new int[0];

    public void add(int value) {
        addAll(value);
    }

    public void addAll(int... arrayValue) {
        int[] newArray = new int[array.length + arrayValue.length];
        System.arraycopy(array, 0 , newArray, 0, array.length);
        System.arraycopy(arrayValue, 0, newArray, array.length, arrayValue.length);
        array = newArray;
    }

    public Integer get(int index) {
        if ((index >= 0) && (index < array.length)) {
            return array[index];
        } else {
            return null;
        }
    }

    public void set(int index, int value) {
        if (index < array.length) {
            array[index] = value;
        }
    }

    public int size() {
        return array.length;
    }

    public boolean remove(int index) {
        if (index < array.length) {
            int[] newArray = new int[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
            array = newArray;
            return true;
        }
        return false;
    }

    public Integer getMax () {
        if (array.length > 0) {
            int maxValue = array[0];
            for (int element : array) {
                if (element > maxValue) {
                    maxValue = element;
                }
            }
            return maxValue;
        }
        return null;
    }

    public Integer getMin () {
        if (array.length > 0) {
            int minValue = array[0];
            for (int element : array) {
                if (element < minValue) {
                    minValue = element;
                }
            }
            return minValue;
        }
        return null;
    }

    public Double average () {
        if (array.length > 0) {
            double average = 0;
            for (int element : array) {
                average += element;
            }
            return average /= array.length;
        }
        return null;
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
