import java.util.ArrayList;
import java.util.List;


public class Session implements GameConfig {
    private final String word;
    private final List<Character> guessedletters;
    private final int maxAttempts;
    private int attempts;
    private final StringBuilder currentWord;

    public Session(String word, int maxAttempts) {
        this.word = word;
        this.currentWord = new StringBuilder("*".repeat(word.length()));
        this.maxAttempts = maxAttempts;
        this.attempts = maxAttempts;
        this.guessedletters = new ArrayList<>();
    }

    public void startGame() {
        System.out.println("Слово состоит из " + word.length() + " букв.");
        System.out.println("У Вас есть " + maxAttempts + " попыток.");
    }

    public void endGame() {
        System.out.println("\nВы завершили игру досрочно.");
        System.exit(0);
    }

    public void usedLetter(char letter) {
        if (guessedletters.contains(letter)) {
            System.out.println("Вы уже вводили эту букву.\n");
            return;
        }

        guessedletters.add(letter);

        if (word.indexOf(letter) >= 0) {
            System.out.println("Попадание! Буква \"" + letter + "\" есть в слове.\n");
            updateWord(letter);
        } else {
            attempts--;
            System.out.println("Мимо, буквы \"" + letter + "\" нет в слове.");
            System.out.println("У Вас осталось попыток: " + attempts + "\n");
        }
    }

    private void updateWord(char letter) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                currentWord.setCharAt(i, letter);
            }
        }
    }

    public void currentWord() {
        System.out.println("Текущее слово: " + currentWord);
    }

    public boolean isGameWon() {
        return currentWord.toString().equals(word);
    }

    public boolean isGameOver() {
        return attempts == 0;
    }
}
