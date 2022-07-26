import java.util.*;

public class TextProcessing {
    public String[] convertToWords(String text) {
        return text.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
    }

    public Set<String> getUniqueWords (String[] words) {
        return new HashSet<>(Arrays.asList(words));
    }

    public Map<String, Integer> countUniqueWords (String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        return wordsMap;
    }
}
