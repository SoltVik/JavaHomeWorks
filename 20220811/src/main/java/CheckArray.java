import java.util.Arrays;
import java.util.stream.IntStream;

public class CheckArray {

    public Integer[] getAllAfterLastNumber (Integer[] array, int number) {
        if (!containsInArray(array, number)) {
            throw new RuntimeException("The array doesn't contain a number: " + number);
        }

        int idx = lastIndexOf(array, number);

        Integer[] result = new Integer[array.length-idx-1];
        System.arraycopy(array, idx+1, result, 0, (array.length-idx-1));

        return result;
    }

    public boolean containsInArray (Integer[] array, int number) {
        return Arrays.stream(array)
                .anyMatch(n -> n == number);
    }

    public boolean notInArray (Integer[] array, int num1, int num2) {
        return Arrays.stream(array)
                .anyMatch(n -> n != num1 && n != num2);
    }

    private int lastIndexOf(Integer[] array, int number) {
        return IntStream
                .range(0, array.length)
                .filter(i -> array[i] == number)
                .max().getAsInt();
    }

    public boolean isArrayOnlyFromNumbers(Integer[] array, int num1, int num2) {
        return (containsInArray(array, num1) && containsInArray(array, num2)) && (!notInArray(array, num1, num2));
    }
}
