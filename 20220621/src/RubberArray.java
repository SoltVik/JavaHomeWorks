import java.util.Arrays;

public class RubberArray {
    private int [] array;

    public void add(int value) {
        if (array == null) {
            array = new int[1];
            array[0] = value;
        } else {
            int[] newArray = new int[array.length + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            newArray[array.length] = value;
            array = newArray;
        }
    }

    public Integer get(int index) {
        if ((index >= 0) && (index < array.length)) {
            return array[index];
        } else {
            return null;
        }
    }

    public int size() {
        return (array == null) ? 0 : array.length;
    }

    public void remove(int index) {
        if (array != null) {
            if (index < array.length) {
                int[] newArray = new int[array.length - 1];
                System.arraycopy(array, 0, newArray, 0, index);
                System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
                array = newArray;
            }
        }
    }

    public Integer getMax () {
        if (array != null) {
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
        if (array != null) {
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
        if (array != null) {
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
        return (array == null) ? "[]" : Arrays.toString(array);
    }
}
