package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private final List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (isValid(word)) {
            words.add(word);
        }
    }

    private boolean isValid(String word) {
        if (!word.equals(word.toLowerCase())) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        return true;
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
