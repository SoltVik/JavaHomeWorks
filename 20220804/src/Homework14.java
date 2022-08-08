/**
 * Java. Homework #14
 *
 * @author Viktors Soltums
 * @version 6 Aug 2022
 */
/*
Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).


 */
public class Homework14 {
    public static void main(String[] args) {

        TestException exception = new TestException();

        String[][] array1 = new String[3][3];
        String [][] array2 = {{"5","7","3","17"}, {"7","0","1","12"}, {"8","a","2","3"}, {"5","3","15","2"}};
        String [][] array3 = {{"5","7","3","17"}, {"7","0","1","12"}, {"8","6","2","3"}, {"5","3","15","2"}};
        String [][] raggedArray = {{"1", "2", "3", "4"}, {"1","2","3"}, {"1","2"}, {"1"}};

        Integer sum = null;

        try {
            sum = exception.sumAllInArray(array3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        System.out.println((sum == null) ? "Error in array" : "Summa of all elements is: " + sum);
    }
}