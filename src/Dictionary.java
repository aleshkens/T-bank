import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final List<String> words;

    public Dictionary() {
        words = Arrays.asList("apple", "banana", "pear", "raspberry");
    }
    public String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}