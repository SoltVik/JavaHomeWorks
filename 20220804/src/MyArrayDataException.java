public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException() {
        super("Transform denied.");
    }

    public MyArrayDataException(int line, int column) {
        super("Transform denied - wrong data type in cell["+ line +"]["+ column +"].");
    }
}
