import java.util.Arrays;
import java.util.Iterator;

public class RubberArray<E> implements Iterable{
    private Object[] array = new Object[0];


    RubberArray(E... arrayValue) {
        addAll(arrayValue);
    }

    RubberArray() {
    }

    public void add(E value) {
        Object[] newArray = new Object[array.length + 1];
        System.arraycopy(array, 0 , newArray, 0, array.length);
        newArray[newArray.length - 1] = value;
        array = newArray;
    }

    public boolean add(int index, E value) {
        return addAll(index, value);
    }

    public void addAll(E[] arrayValue) {
        Object[] newArray = new Object[array.length + arrayValue.length];
        System.arraycopy(array, 0 , newArray, 0, array.length);
        System.arraycopy(arrayValue, 0, newArray, array.length, arrayValue.length);
        array = newArray;
    }

    public boolean addAll (int index, E... arrayValue) {
        if (index < array.length && index >= 0) {
            Object[] newArray = new Object[array.length + arrayValue.length];
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

    public Object get(int index) {
        if ((index >= 0) && (index < array.length)) {
            return array[index];
        } else {
            return null;
        }
    }

    public boolean set(int index, E value) {
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
            Object[] newArray = new Object[array.length - 1];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
            array = newArray;
            return true;
        }
        return false;
    }

    public boolean contains(E value) {
        for (Object element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
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
        private int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < array.length;
        }

        @Override
        public Object next() {
            return array[pointer++];
        }
    }


}
