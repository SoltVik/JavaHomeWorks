import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class RubberArray implements Iterable {
    private int[] array = new int[0];

    RubberArray(int... arrayValue) {
        addAll(arrayValue);
    }

    RubberArray() {
    }

    public void add(int value) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0 , newArray, 0, array.length);
        newArray[newArray.length - 1] = value;
        array = newArray;
    }

    public boolean add(int index, int value) {
        return addAll(index, value);
    }

    public void addAll(int[] arrayValue) {
        int[] newArray = new int[array.length + arrayValue.length];
        System.arraycopy(array, 0 , newArray, 0, array.length);
        System.arraycopy(arrayValue, 0, newArray, array.length, arrayValue.length);
        array = newArray;
    }

    public boolean addAll (int index, int... arrayValue) {
        if (index < array.length && index >= 0) {
            int[] newArray = new int[array.length + arrayValue.length];
            System.arraycopy(array, 0 , newArray, 0, index);
            System.arraycopy(arrayValue, 0, newArray, index, arrayValue.length);
            System.arraycopy(array, index, newArray, index+arrayValue.length, array.length-index);
            array = newArray;
            return true;
        } else if (index == array.length) {
            addAll(arrayValue);
            return true;
        }
        return false;
    }

    public Integer get(int index) {
        if ((index >= 0) && (index < array.length)) {
            return array[index];
        } else {
            return null;
        }
    }

    public boolean set(int index, int value) {
        if (index < array.length) {
            array[index] = value;
            return true;
        }
        return false;
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
            return average / array.length;
        }
        return null;
    }

    public boolean contains(int value) {
        return IntStream.of(array).anyMatch(x -> x == value);
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < array.length;
        }

        @Override
        public Object next() {
            return array[cursor++];
        }
    }

}
