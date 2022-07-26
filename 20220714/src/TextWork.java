import java.util.Arrays;
import java.util.Map;

/**
 * Java. Homework #12 part 1
 *
 * @author Viktors Soltums
 * @version 26 Jul 2022
 */
/*
Имеется текст (10-20 слов, должны встречаться повторяющиеся) без знаков препинания и больших букв.
Получить массив слов из текста. Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
 */
public class TextWork {
    public static void main(String[] args) {
        String myText = new TextSource().getText();
        TextProcessing text = new TextProcessing();

        String[] words = text.convertToWords(myText);

        System.out.println("Text: " + myText);
        System.out.println("All words: " + Arrays.toString(words));
        System.out.println("Unique words: " + text.getUniqueWords(words));

        for (Map.Entry<String, Integer> word : text.countUniqueWords(words).entrySet())
        {
            System.out.print(word.getKey() + ":" + word.getValue() + ", ");
        }
    }
}