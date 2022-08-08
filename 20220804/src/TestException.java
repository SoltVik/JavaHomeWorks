public class TestException {

    public int sumAllInArray (String[][] array) {
        if (wrongArraySize(array, 4, 4)) {
            throw new MyArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int temp;
                try {
                    temp = Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
                sum += temp;
            }
        }

        return sum;
    }

    public boolean wrongArraySize (String[][] array, int lines, int columns) {
        if (array.length == lines) {
            for (String[] strings : array) {
                if (strings.length != columns) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
