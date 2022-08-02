import java.util.*;

public class TextProcessing {
    public String[] convertToWords(String text) {
        return text.toLowerCase().split("\\W+");
    }

    public Set<String> getUniqueWords (String[] words) {
        return new HashSet<>(Arrays.asList(words));
    }

    public Map<String, Integer> countUniqueWords (String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            Integer count = wordsMap.getOrDefault(word,0);
            wordsMap.put(word, count + 1);
        }
        return wordsMap;
    }
}
