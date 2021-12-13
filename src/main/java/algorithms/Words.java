package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private final List<String> words = new ArrayList<>();

    public void addWord(String word) {
        for (Character c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
            if (Character.isWhitespace(c)) {
                throw new IllegalArgumentException("It should be one word!");
            }
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> once = new ArrayList<>();
        for (String word : words) {
            if (once.contains(word)) {
                return true;
            }
            once.add(word);
        }
        return false;
    }

    public List<String> getWords() {
        return List.copyOf(words);
    }

}
